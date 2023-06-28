package com.example.monthly.controller.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.service.board.BrandFileService;
import com.example.monthly.service.board.BrandService;
import com.example.monthly.vo.BrandFileVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brands/*")
public class BrandRestController {
    private final BrandService brandService;
    private final BrandFileService brandFileService;

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

//    @GetMapping("/findBrandFile")
//    public BrandFileDto findBrandFileInfo(HttpServletRequest req){
//        Long sellerNumber =(Long)req.getSession().getAttribute("sellerNumber");
//        return brandFileService.findBrandFile(sellerNumber);
//    }

}
