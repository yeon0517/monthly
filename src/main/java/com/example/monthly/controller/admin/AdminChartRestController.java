package com.example.monthly.controller.admin;

import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.AdminChartVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/allChart/{sellerRegistertDate}")
    public List<AdminChartVo> getSellerApplication(@PathVariable("sellerRegistertDate") Date sellerRegistertDate) {
        return adminService.getSellerApplication(sellerRegistertDate);
    }
}
