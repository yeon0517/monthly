package com.example.monthly.controller.seller;

import com.example.monthly.dto.ProductFileDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.board.ProductFileService;
import com.example.monthly.service.board.ProductService;
import com.example.monthly.service.seller.SellerService;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.PageVo;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers/*")
public class SellerRestController {
    private final SellerService sellerService;
    private final ProductService productService;
    private final ProductFileService productFileService;

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

//    제품리스트
    @GetMapping("/list")
    public List<ProductVo> list(HttpServletRequest req){
        Long sellerNumber = (Long) req.getSession().getAttribute("sellerNumber");
        return productService.findAllProduct(sellerNumber);}

//      제품리스트 페이징처리
    @GetMapping("/list/{page}")
    public Map<String, Object> productListPage(HttpServletRequest req, @PathVariable("page")int page) {
        Long sellerNumber = (Long) req.getSession().getAttribute("sellerNumber");
        Criteria criteria = new Criteria(page, 10);
        PageVo pageVo = new PageVo(criteria, productService.getTotal(sellerNumber));
        List<ProductVo> productList = productService.findListPage(criteria, sellerNumber);
        Map<String, Object> productMap = new HashMap<>();
        productMap.put("pageVo", pageVo);
        productMap.put("productList", productList);
        return productMap;
    }

    @GetMapping("/modify")
    public List<ProductFileDto> files(Long productNumber){
        List<ProductFileDto> files = productFileService.getProductFileList(productNumber);
        return files;
    }
}
//@PathVariable("sellerId")