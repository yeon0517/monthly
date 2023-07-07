package com.example.monthly.service.board;

import com.example.monthly.dto.ProductFileDto;
import com.example.monthly.mapper.ProductFileMapper;
import com.example.monthly.vo.ProductFileListVo;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductFileService {
    private final ProductFileMapper productFileMapper;

    @Value("${product.file.dir}")
    private String productFileDir;
//  제품번호로 파일리스트 조회
    public List<ProductFileDto> proFileList(Long productNumber){
        if (productNumber == null) {
            throw new IllegalArgumentException("제품 번호 누락");
        }

        return productFileMapper.proFileSelect(productNumber);
    }

//    메인사진과 상세사진구분해서 리스트에 넣어 넘겨주기
    public ProductFileListVo getSeperatedList(List<ProductFileDto> productFileDtoList){
        ProductFileListVo productFiles = new ProductFileListVo();
        List<ProductFileDto> files = new ArrayList<ProductFileDto>();

        for(ProductFileDto file : productFileDtoList){
            if(file.getProductFileSize()=="m"){
                productFiles.setMainFile(file);
            }else{
                files.add(file);
            }
        }
        productFiles.setFiles(files);
        return productFiles;
    }

//    메인사진조회
    public ProductFileDto getMainFile(Long productNumber){
        if(productNumber==null){throw new IllegalArgumentException("제품번호누락");}
        return productFileMapper.selectMainProductFile(productNumber);
    }
//    상세사진리스트조회
    public List<ProductFileDto> getProductFileList(Long productNumber){
        if(productNumber==null){throw new IllegalArgumentException("제품번호누락");}
        return productFileMapper.selectDetailProductFile(productNumber);
    }

//    파일정보 DB에 저장
    public void register(ProductFileDto productFileDto){
        if(productFileDto==null){throw new IllegalArgumentException("제품파일정보누락");}
        productFileMapper.insertProductFile(productFileDto);
    }

//    제품번호로 대표사진삭제
    public void removeMainFile(Long productNumber){
        if(productNumber == null){ throw new IllegalArgumentException("제품번호누락(file)"); }
        ProductFileDto file = productFileMapper.selectMainProductFile(productNumber);
        File target = new File(productFileDir, file.getProductFileUploadPath()+"/"+file.getProductFileUuid()+"_"+file.getProductFileName());
        File thumbnail = new File(productFileDir, file.getProductFileUuid()+"/th_"+file.getProductFileUuid()+"_"+file.getProductFileName());
        if(target.exists()){target.delete();}
        if(thumbnail.exists()){thumbnail.delete();}
        productFileMapper.deleteMainFile(productNumber);
    }
//   제품번호로 상세이미지 파일정보All 삭제
    public void remove(Long productNumber){
        if(productNumber == null){ throw new IllegalArgumentException("제품번호누락(file)"); }
        List<ProductFileDto> fileDtoList = productFileMapper.selectDetailProductFile(productNumber);
        for(ProductFileDto file : fileDtoList){
           File target = new File(productFileDir, file.getProductFileUploadPath()+"/"+file.getProductFileUuid()+"_"+file.getProductFileName());
           File thumbnail = new File(productFileDir, file.getProductFileUuid()+"/th_"+file.getProductFileUuid()+"_"+file.getProductFileName());
           if(target.exists()){target.delete();}
           if(thumbnail.exists()){thumbnail.delete();}
        }
           productFileMapper.deleteProductFiles(productNumber);
    }
//    실제파일 1개 저장처리 - 무슨파일을 받든 일단 저장한다
    public ProductFileDto saveFile(MultipartFile file) throws IOException{

        String originName = file.getOriginalFilename();
        originName = originName.replaceAll("\\s+","");
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString()+"_"+originName;
        File uploadPath = new File(productFileDir, getUploadPath());

        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        File uploadFile = new File(uploadPath, sysName);
        file.transferTo(uploadFile);

        if(Files.probeContentType(uploadFile.toPath()).startsWith("image")){

            FileOutputStream out = new FileOutputStream(new File(uploadPath,"th_"+sysName));
            Thumbnailator.createThumbnail(file.getInputStream(),out,300,300);
            out.close();
        }

        ProductFileDto productFileDto = new ProductFileDto();
        productFileDto.setProductFileUuid(uuid.toString());
        productFileDto.setProductFileName(originName);
        productFileDto.setProductFileUploadPath(getUploadPath());

        return productFileDto;
    }
//    파일리스트 DB 등록 및 저장처리
    public void registerAndSaveFiles(List<MultipartFile> files, String productFileSize, Long productNumber) throws IOException{
        for(MultipartFile file : files){
            ProductFileDto productFileDto = saveFile(file);
            productFileDto.setProductNumber(productNumber);
            productFileDto.setProductFileSize(productFileSize);
            register(productFileDto);
        }
    }
//    대표파일 1장 DB 등록 및 저장처리
    public void registerAndSaveMainFile(MultipartFile file, String productFileSize, Long productNumber) throws IOException{
        ProductFileDto productFileDto = saveFile(file);
        productFileDto.setProductNumber(productNumber);
        productFileDto.setProductFileSize(productFileSize);
        register(productFileDto);
    }

//    파일이 저장되는 하위경로 날짜 구하기
    private String getUploadPath(){return new SimpleDateFormat("yyyy/MM/dd").format(new Date());}

}
