package com.example.monthly.service.board;

import com.example.monthly.dto.ProductDto;
import com.example.monthly.mapper.ProductMapper;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductMapper productMapper;

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
    public void registProduct(ProductDto productDto){
        if(productDto == null){
            throw new IllegalArgumentException("상품정보 누락");
        }
        productMapper.insertProduct(productDto);
    }
//    상품삭제
    public void removeProduct(Long productNumber){
        if(productNumber== null){
            throw new IllegalArgumentException("상품번호 누락");
        }
        productMapper.deleteProduct(productNumber);
    }
//    상품수정
    public void modifyProduct(ProductDto productDto){
        if(productDto == null){
            throw new IllegalArgumentException("상품 수정 정보 누락");
        }
        productMapper.updateProduct(productDto);
    }

    public void modifyProduct(ProductDto productDto, List<MultipartFile>files, MultipartFile mainFile){
        if(productDto==null||files==null||mainFile==null){
            throw new IllegalArgumentException("제품 수정 매개변수 null체크");
        }
//        productFileService.remove(productDto.getProductNumber());
//        productFileService.registerAndSaveFiles(files, productDto.getProductNumber());
//        productFileService.registerAndSaveFile(mainFile, productDto.getProductNumber());???
        productMapper.updateProduct(productDto);
    }


//    상품리스트조회

//    상품 수량 변경
    public void amountChange(ProductVo productVo){
        if (productVo == null) {
            throw new IllegalArgumentException("상품 수량 등 정부 누락");
        }

        productMapper.amountChange(productVo);
    }

}
