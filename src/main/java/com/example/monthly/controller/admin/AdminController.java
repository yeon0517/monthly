package com.example.monthly.controller.admin;

import com.example.monthly.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
