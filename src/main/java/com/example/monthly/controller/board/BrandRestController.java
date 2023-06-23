package com.example.monthly.controller.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.service.board.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brands/*")
public class BrandRestController {
    private final BrandService brandService;

    @GetMapping("/findInfo")
    public BrandDto findBrandInfo(HttpServletRequest req){
        Long sellerNumber =  (Long)req.getSession().getAttribute("sellerNumber");
        return brandService.findBrandInfo(sellerNumber);
    }

    @PostMapping("/saveInfo")
    public void saveBrandInfo(BrandDto brandDto, HttpServletRequest req){
        Long sellerNumber = (Long)req.getSession().getAttribute("sellerNumber");
        brandDto.setSellerNumber(sellerNumber);
        brandService.saveBrandInfo(brandDto);
    }
}
