package com.example.monthly.controller.admin;

import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.AdminChartVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/adminChart/*")
public class AdminChartRestController {
    private final AdminService adminService;

//    @GetMapping("/allChart/{sellerRegistertDate}")
//    public List<AdminChartVo> getSellerApplication(@PathVariable("sellerRegistertDate")Date sellerRegistertDate)
//    {
//        return adminService.getSellerApplication(sellerRegistertDate);
//    }

    @GetMapping("/sellerChart")
    public List<AdminChartVo> getSellerApplication() {
        System.out.println("출략");
        return adminService.getSellerApplication();
    }

    @GetMapping("/sellerChartTwo")
    public List<AdminChartVo> getPaymentCount() {
        System.out.println("예압~!");
        List<AdminChartVo> result = adminService.getPaymentCount();
        System.out.println(result);
        return result;
    }

}









