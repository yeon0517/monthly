package com.example.monthly.controller.user;

import com.example.monthly.dto.UserDto;
import com.example.monthly.service.seller.SellerService;
import com.example.monthly.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

// 로그인, 회원가입, 정보수정 등
@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    public void mypage(){

    }
    @GetMapping("/userModify")
    public void userModify(){

    }
    @GetMapping("/login")
    public String login(){
        return "user/login"; }

    @GetMapping("/join")
    public String join(){
        return "user/join"; }

    @PostMapping("/join")
    public RedirectView join(UserDto userDto){
        userService.register(userDto);
        return new RedirectView("/user/joinOK"); }

    @GetMapping("/joinOK")
    public String joinOK(){
        return "user/join_ok"; }

    @GetMapping("/findId")
    public String findId(){
        return "user/find_id"; }

    @GetMapping("/findIdOK")
    public String findIdOK(){
        return "user/find_id_ok"; }

    @GetMapping("/findPw")
    public String findPw(){
        return "user/find_pw"; }

    @GetMapping("/findPwOK")
    public String findPwOK(){
        return "user/find_pw_ok"; }


}
