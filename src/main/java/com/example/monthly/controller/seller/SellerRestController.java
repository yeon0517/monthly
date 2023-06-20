package com.example.monthly.controller.seller;

import com.example.monthly.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers/*")
public class SellerRestController {
    private final SellerService sellerService;

    @GetMapping("/checkId")
    public int checkId(String sellerId){
        return sellerService.sellerIdCheck(sellerId);
    }
}
//@PathVariable("sellerId")