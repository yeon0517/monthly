package com.example.monthly.controller.seller;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 판매자 브랜드관리, 제품등록, 제품관리 등과 관련
@Controller
@RequiredArgsConstructor
@RequestMapping("/seller/*")
public class SellerController {
    private final SellerService sellerService;

    @GetMapping("/login")
    public String login(){
        return "seller/seller_login"; }

    @GetMapping("/main")
    public String main(){
        return "seller/seller_main"; }

    @GetMapping("/apply")
    public String apply(){
        return "seller/seller_apply";
    }

    @PostMapping("/apply")
    public RedirectView sellerApply(SellerDto sellerDto){
        sellerService.sellerApply(sellerDto);
        return new RedirectView("/board/board_main");
    }

    @GetMapping("/brand")
    public String brand(){return "seller/seller_brand";}

    @GetMapping("/list")
    public String productList(){return "seller/seller_product_list";}

    @GetMapping("/modify")
    public String productModify(){return "seller/seller_product_modify";}

    @GetMapping("/register")
    public String productRegister(){return "seller/seller_product_register";}
}
