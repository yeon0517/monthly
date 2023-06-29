package com.example.monthly.controller.seller;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers/*")
public class SellerRestController {
    private final SellerService sellerService;
//  판매자아이디 중복검사
    @GetMapping("/checkId")
    public int checkId(String sellerId){
        return sellerService.sellerIdCheck(sellerId);
    }
//    판매자 현재 비밀번호 확인
    @GetMapping("/checkPw")
    public int checkPassword(String sellerPassword, HttpServletRequest req){
        Long sellerNumber =  (Long)req.getSession().getAttribute("sellerNumber");
        return sellerService.checkCurrentPw(sellerNumber, sellerPassword);
    }
    @PatchMapping("/modifyInfo")
    public void modifySellerInfo(@RequestBody SellerDto sellerDto, HttpServletRequest req ){
        Long sellerNumber = (Long)req.getSession().getAttribute("sellerNumber");
        sellerDto.setSellerNumber(sellerNumber);
        sellerService.modifySellerInfo(sellerDto);
    }
    @GetMapping("/findInfo")
    public SellerDto findSellerInfo(HttpServletRequest req){
        Long sellerNumber =  (Long)req.getSession().getAttribute("sellerNumber");
        return sellerService.findSellerInfo(sellerNumber);
    }
}
//@PathVariable("sellerId")