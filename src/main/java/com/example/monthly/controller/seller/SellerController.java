package com.example.monthly.controller.seller;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.board.BrandService;
import com.example.monthly.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final BrandService brandService;

    @GetMapping("/login")
    public String login(){ return "seller/seller_login"; }

    @PostMapping("/login")
    public RedirectView login(String sellerId, String sellerPassword, HttpServletRequest req){
        try {
            Long sellerNumber = sellerService.findSellerNumber(sellerId,sellerPassword);
            req.getSession().setAttribute("sellerNumber",sellerNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/seller/login");
        }
        return new RedirectView("/seller/main");
    }
    @GetMapping("/main")
    public String main(){
        return "seller/seller_main"; }

    @GetMapping("/apply")
    public String apply(){
        return "seller/seller_apply";
    }

    @PostMapping("/apply")
    public RedirectView sellerApply(SellerDto sellerDto, RedirectAttributes redirectAttributes){
        sellerService.sellerApply(sellerDto);
        redirectAttributes.addFlashAttribute("sellerId",sellerDto.getSellerId());
        redirectAttributes.addFlashAttribute("sellerEmail",sellerDto.getSellerEmail());
        redirectAttributes.addFlashAttribute("sellerName",sellerDto.getSellerName());
        return new RedirectView("/seller/apDone");
    }
    @GetMapping("/apDone")
    public String applyDone(){return "seller/seller_apply_done";}

    @GetMapping("/brand")
    public String brand(Model model, HttpServletRequest req){
        Long sellerNumber = (Long) req.getSession().getAttribute("sellerNumber");
        SellerDto sellerDto = sellerService.findSellerInfo(sellerNumber);
        BrandDto brandDto = brandService.findBrandInfo(sellerNumber);
        model.addAttribute("seller", sellerDto);
        model.addAttribute("brand", brandDto);
        return "seller/seller_brand";}

    @GetMapping("/list")
    public String productList(){return "seller/seller_product_list";}

    @GetMapping("/modify")
    public String productModify(){return "seller/seller_product_modify";}

    @GetMapping("/register")
    public String productRegister(){return "seller/seller_product_register";}

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest req){
        req.getSession().invalidate();
        return new RedirectView("/seller/login");
    }

}
