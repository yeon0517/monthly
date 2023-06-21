package com.example.monthly.controller.board;

import com.example.monthly.service.board.ProductService;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//메인, aboutMonthly, 브랜드리스트, 브랜드페이지, 상품리스트, 상품상세페이지 등
@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

    private final ProductService productService;

    @GetMapping("/productInfo")
    public String productInfo(Long productNumber, Model model){
//        productMain에서 productNumber을 get 형식으로 넘겨주고 나는 그걸 받아서  넣어준다.
        ProductVo productVo = productService.productView(1L);
        System.out.println("==================" + productVo);
        model.addAttribute("product",productVo);
        return "board/productInfo";
    }

    @GetMapping("/main")
    public String main(){
        return "board/board_main";

    }

    @GetMapping("/brand")
    public String brand(){
        return "board/board_brand";
    }

    @GetMapping("/product")
    public String product(){
        return "board/board_product";
    }

    @GetMapping("/brandDetail")
    public String brandDetail(){
        return "board/board_branddetail";
    }

    @GetMapping("/about")
    public String about(){
        return "board/board_about";
    }


}
