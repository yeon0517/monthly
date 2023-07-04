package com.example.monthly.controller.admin;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.ProductVo;
import com.example.monthly.vo.SearchVo;
import com.example.monthly.vo.SubsVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //화면 전환 이뤄지지 않음
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/search/*")
public class RestSearchController {

    private final AdminService adminService;

    //판매자 관리 페이지 기간별,조건별 전체 검색
    @GetMapping("/sellers")
    public List<SellerDto> searchSelect(String period, String searchSelect, String searchInput) {
        SearchVo searchVo = new SearchVo();
        searchVo.setSearchSelect(searchSelect);
        searchVo.setPeriod(period);
        searchVo.setSearchInput(searchInput);
        System.out.println("============================");
        System.out.println(searchVo);
        return adminService.selectSeller(searchVo);
    }

    //판매자 영업 상태 수정기능
    @PatchMapping("/{sellerStatus}")
    public void statusModify(@PathVariable("sellerStatus") int sellerStatus,
                             @RequestBody SellerDto sellerDto) {
        sellerDto.setSellerStatus(sellerStatus);
        adminService.statusModify(sellerDto);

    }

    //상품 카테고리별 검색 기능
    @GetMapping("/products")
    public List<ProductVo> searchProduct(String searchSelect, String searchInput) {
        SearchVo searchVo = new SearchVo();
        searchVo.setSearchSelect(searchSelect);
        searchVo.setSearchInput(searchInput);
        System.out.println("=============================");
        System.out.println(searchVo);
        return adminService.searchProduct(searchVo);
    }

    //상품 상태 수정기능
    @PatchMapping("/products/{productStatus}")
    public void goodsStModify(@PathVariable("productStatus") int productStatus,
                              @RequestBody ProductVo productVo) {
        productVo.setProductStatus(productStatus);
        adminService.goodsStModify(productVo);
    }


    //===========구독자 페이지===============

//    @GetMapping("/subsUsers")
//    public List<SubsVo> brandSubsUserList(String subscriberInput, Long brandNumber) {
//        SearchVo searchVo = new SearchVo();
//        searchVo.setSubscriberInput(subscriberInput);
//        searchVo.setBrandNumber(brandNumber);
//        System.out.println("====================");
//        System.out.println(searchVo);
//        return adminService.brandSubsUserList(searchVo);
//    }

    @GetMapping("/subs")
    public List<SubsVo> productSubsUserList(String subscriberInput, Long productNumber) {
        SearchVo searchVo = new SearchVo();
        searchVo.setSubscriberInput(subscriberInput);
        searchVo.setProductNumber(productNumber);
        System.out.println("====================");
        System.out.println(searchVo);
        return adminService.productSubsUserList(searchVo);

    }
}
