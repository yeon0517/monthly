package com.example.monthly.service.board;

import com.example.monthly.dto.ProductDto;
import com.example.monthly.mapper.ProductMapper;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductFileService productFileService;

    //조회
    @Transactional(readOnly = true)
    public ProductVo productView(Long productNumber){
        if (productNumber == null) {
            throw new IllegalArgumentException("상품번호 누락");
        }
        return Optional.ofNullable(productMapper.selectProduct(productNumber))
                .orElseThrow(() -> {throw new IllegalArgumentException("존재하지 않는 상품");});
    }

//   상품등록
    public void registProduct(ProductDto productDto, List<MultipartFile>files, MultipartFile file){
        if(productDto == null){
            throw new IllegalArgumentException("상품정보 누락");
        }
        productMapper.insertProduct(productDto);
        //       +파일등록추가
        if(!files.isEmpty()){
            try {
//                상세사진리스트등록
                productFileService.registerAndSaveFiles(files, "d", productDto.getProductNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!file.isEmpty()){
            try {
//                대표사진등록
                productFileService.registerAndSaveMainFile(file,"m", productDto.getProductNumber());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
//    상품삭제
    public void removeProduct(Long productNumber){
        if(productNumber== null){
            throw new IllegalArgumentException("상품번호 누락");
        }
        productFileService.remove(productNumber);
        productMapper.deleteProduct(productNumber);
    }
//    상품수정
    public void modifyProduct(ProductDto productDto){
        if(productDto == null){
            throw new IllegalArgumentException("상품 수정 정보 누락");
        }
        productMapper.updateProduct(productDto);
    }

    public void modifyProduct(ProductDto productDto, List<MultipartFile>files, MultipartFile file) throws IOException {
        if(productDto==null || files==null || file==null){
            throw new IllegalArgumentException("제품 수정 매개변수 null체크");
        }
        Long productNumber = productDto.getProductNumber();
        productFileService.remove(productNumber); //원래있던 파일은 지우고
        productFileService.registerAndSaveMainFile(file, "m",productNumber); //대표사진다시저장
        productFileService.registerAndSaveFiles(files, "d",productNumber); //리스트다시저장
        productMapper.updateProduct(productDto);
    }


//    상품리스트조회
    @Transactional(readOnly = true)
    public List<ProductVo> findAllProduct(Long sellerNumber){
        if(sellerNumber==null){throw new IllegalArgumentException("판매자번호 누락");}
       return productMapper.selectList(sellerNumber);
    }

    @Transactional(readOnly = true)
    public int getTotal(Long sellerNumber){
        if(sellerNumber==null){throw new IllegalArgumentException("판매자번호 누락");}
        return productMapper.selectTotal(sellerNumber);}

    public List<ProductVo> findListPage(Criteria criteria, Long sellerNumber){
        if(criteria==null || sellerNumber ==null){
            throw new IllegalArgumentException("페이징 정보 누락");
        }
        return productMapper.selectListPage(criteria, sellerNumber);
    }
}
