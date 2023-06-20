package com.example.monthly.controller.admin;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.service.admin.AdminService;
import com.example.monthly.vo.SearchVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {
    private final AdminService adminService;



    @GetMapping("/login")
    public String login(){
        return "seller/seller_login";
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
    public String subMember(){
        return "admin/manager_seller_detail";}

    @GetMapping("/search")
    public String searchSeller(SearchVo searchVo, Model model){
       List<SellerDto> searchList = adminService.findAll(searchVo);
       model.addAttribute("searchList",searchList);
               return "admin/manager_seller";

    }


}
