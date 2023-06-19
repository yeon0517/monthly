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

    @GetMapping("/board_main")
    public void main(){
    }

    @GetMapping("/board_brand")
    public void mainbrand(){
    }

    @GetMapping("/board_product")
    public void mainproduct(){
    }

    @GetMapping("/board_branddetail")
    public void mainbrandDetail(){
    }

    @GetMapping("/board_about")
    public void mainabout(){
    }


}
