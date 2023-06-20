package com.example.monthly.controller.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//메인, aboutMonthly, 브랜드리스트, 브랜드페이지, 상품리스트, 상품상세페이지 등
@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

    @GetMapping("/productInfo")
    public void productInfo(){

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
