package com.example.monthly.controller.board;

import com.example.monthly.service.board.ProductService;
import com.example.monthly.service.board.ReviewService;
import com.example.monthly.service.user.MypageService;
import com.example.monthly.vo.*;

import com.example.monthly.mapper.BoardMapper;
import com.example.monthly.service.board.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//메인, aboutMonthly, 브랜드리스트, 브랜드페이지, 상품리스트, 상품상세페이지 등
@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

    private final ProductService productService;

    private final BoardService boardService;

    private final ReviewService reviewService;

    private final MypageService mypageService;


    @GetMapping("/productInfo")
    public String productInfo(Long productNumber, Model model, Criteria criteria, HttpServletRequest req){
//        productMain에서 productNumber을 get 형식으로 넘겨주고 나는 그걸 받아서  넣어준다.
        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        ProductVo productVo = productService.productView(productNumber);
        int reviewCnt = reviewService.findTotal(productNumber);
        Long subsNumber = mypageService.reSubs(productNumber,userNumber);
        model.addAttribute("pageInfo",new PageVo(criteria,reviewCnt));
        model.addAttribute("reviewCnt",reviewCnt);
        model.addAttribute("subsNumber",subsNumber);
        model.addAttribute("product",productVo);
        return "board/productInfo";
    }

    @GetMapping("/main")
    public String main(Model model){
//        List<ProductFileVo> mains = boardService.mainAll();
//        model.addAttribute("mainAll",boardService.mainAll());
        model.addAttribute("brandSelect",boardService.selectAllBrands());
        model.addAttribute("productSelect" , boardService.productSelect());
        return "board/board_main";

    }

    @GetMapping("/brand")
    public String brand(Model model) {
        List<BrandFileVo> brands = boardService.selectAllBrands();
        model.addAttribute("selectAllBrands", brands);
        return "board/board_brand";
    }

    @GetMapping("/product")
    public String product(Model model){
        model.addAttribute("productSelect" , boardService.productSelect());
        return "board/board_product";
    }

    @GetMapping("/brandDetail")
    public String brandDetail(Model model){
        model.addAttribute("brandSelect",boardService.selectAllBrands());
        model.addAttribute("productSelect" , boardService.productSelect());
        return "board/board_branddetail";
    }

    @GetMapping("/about")
    public String about(){
        return "board/board_about";
    }


}
