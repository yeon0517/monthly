package com.example.monthly.controller.admin;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.DeliveryVo;
import com.example.monthly.vo.ProductVo;
import com.example.monthly.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;

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
    public String main(){
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
        adminService.selectSubUser(sellerNumber);
        model.addAttribute("sellerNumber" ,sellerNumber);
        System.out.println("==========================");
        System.out.println(sellerNumber);
        return "admin/manager_seller_detail";}

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest req){
        req.getSession().invalidate();
        return new RedirectView("/seller/login");
    }

}
