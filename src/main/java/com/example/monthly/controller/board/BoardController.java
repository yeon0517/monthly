package com.example.monthly.controller.board;

import com.example.monthly.service.board.ProductService;
import com.example.monthly.service.board.ReviewService;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.PageVo;
import com.example.monthly.vo.ProductVo;

import com.example.monthly.mapper.BoardMapper;
import com.example.monthly.service.board.BoardService;

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

    private final BoardService boardService;

    private final ReviewService reviewService;


    @GetMapping("/productInfo")
    public String productInfo(Long productNumber, Model model, Criteria criteria){
//        productMain에서 productNumber을 get 형식으로 넘겨주고 나는 그걸 받아서  넣어준다.
        ProductVo productVo = productService.productView(1L);
        int reviewCnt = reviewService.findTotal(1L);
        model.addAttribute("pageInfo",new PageVo(criteria,reviewCnt));
        model.addAttribute("reviewCnt",reviewCnt);
        model.addAttribute("product",productVo);
        return "board/productInfo";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("brandSelect",boardService.brandSelect());
        model.addAttribute("productSelect" , boardService.productSelect());
        return "board/board_main";

    }

    @GetMapping("/brand")
    public String brand(Model model){
        model.addAttribute("brandSelect",boardService.brandSelect());
        return "board/board_brand";
    }

    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("productSelect" , boardService.productSelect());
        return "board/board_product";
    }

    @GetMapping("/brandDetail")
    public String brandDetail(Model model){
        model.addAttribute("brandSelect",boardService.brandSelect());
        model.addAttribute("productSelect" , boardService.productSelect());
        return "board/board_branddetail";
    }

    @GetMapping("/about")
    public String about(){
        return "board/board_about";
    }


}
