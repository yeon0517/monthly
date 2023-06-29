package com.example.monthly.controller.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.service.board.BrandFileService;
import com.example.monthly.service.board.BrandService;
import com.example.monthly.vo.BrandFileVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brands/*")
public class BrandRestController {
    private final BrandService brandService;
    private final BrandFileService brandFileService;

    @Value("${brand.file.dir}")
    private String fileDir;

    @GetMapping("/findInfo")
    public BrandDto findBrandInfo(HttpServletRequest req){
        Long sellerNumber =  (Long)req.getSession().getAttribute("sellerNumber");
        return brandService.findBrandInfo(sellerNumber);
    }

    @PostMapping("/saveInfo")
    public void saveBrandInfo(BrandDto brandDto,HttpServletRequest req,
                              @RequestParam("brandFileLong")MultipartFile fileLong,
                              @RequestParam("brandFileSq")MultipartFile fileSq){
        System.out.println("*********&&&&&&&&&&&&&&&***************");
        Long sellerNumber = (Long)req.getSession().getAttribute("sellerNumber");
        Long brandNumber = brandService.checkBrandNumber(sellerNumber);
        brandDto.setSellerNumber(sellerNumber);
//        브랜드 대표 이미지 저장
        if(brandNumber !=null && fileLong != null && fileSq !=null){
            try {
                brandFileService.registerAndSaveBrandFile(fileLong,"long", sellerNumber, brandNumber);
                brandFileService.registerAndSaveBrandFile(fileSq,"square", sellerNumber, brandNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        brandService.saveBrandInfo(brandDto);
    }

//    브랜드파일넘버를 받는다.
    @GetMapping("/findBrandFile")
    public BrandFileDto findBrandFileNumber(String brandFileSize, HttpServletRequest req){
        Long sellerNumber =(Long)req.getSession().getAttribute("sellerNumber");
        Long brandFileNumber = brandFileService.findBrandFileNumber(sellerNumber, brandFileSize);
        return brandFileService.findBrandFile(brandFileNumber);
    }
//    실제 이미지를 띄워준다.
    @GetMapping("/showImg")
    public byte[] showImg(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File(fileDir,fileName));
    }

}
