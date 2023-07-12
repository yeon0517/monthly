package com.example.monthly.controller.admin;

import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.AdminChartVo;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/login")
    public String login(){return "/seller/login";}

    @PostMapping("/login")
    public RedirectView login(String adminId, String adminPassword, HttpServletRequest req){
        try {
            Long adminNumber = adminService.findAdminNumber(adminId, adminPassword);
            req.getSession().setAttribute("adminNumber",adminNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/seller/login");
        }

        return new RedirectView("/admin/main");
    }

    @GetMapping("/main")
    public String sellerStatus(Model model,HttpServletRequest req){



        List<AdminChartVo> sellerStatus = adminService.getSellerStatusByDate();
        List<AdminChartVo> sellerMonth = adminService.sellerMonth();
        List<AdminChartVo> threeAverage = adminService.threeAverage();
        log.info(sellerStatus.toString()); //log.info는 무조건  string값으로
        model.addAttribute("sellerStatus", sellerStatus);
        model.addAttribute("sellerMonth", sellerMonth);
        model.addAttribute("threeAverage", threeAverage);
        return "admin/managerMain";}

    @GetMapping("/allMember")
    public String allMember(){
        return "admin/manager_allMember";}

    @GetMapping("/allGoods")
    public String allGoods(){
        return "admin/manager_allGoods";}


    @GetMapping("/seller")
    public String seller(){
        return "admin/manager_seller";}


    @GetMapping("/subMember")
    public String subMember(Long sellerNumber,Model model){
        model.addAttribute("sellerNumber" ,sellerNumber);
        List<ProductVo> productVo  = adminService.selectSubUser(sellerNumber);
        List<ProductVo> brandName = adminService.brandName(sellerNumber);
        System.out.println("==========================");
        System.out.println(sellerNumber);
        model.addAttribute("product",productVo);
        model.addAttribute("brand",brandName);
        return "admin/manager_seller_detail";}

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest req){
        req.getSession().invalidate();
        return new RedirectView("/seller/login");
    }

}
