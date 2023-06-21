package com.example.monthly.controller.user;


import com.example.monthly.dto.DeliveryDto;
import com.example.monthly.dto.UserDto;
import com.example.monthly.mapper.OrderMapper;
import com.example.monthly.service.order.OrderService;
import com.example.monthly.service.seller.SellerService;
import com.example.monthly.service.user.UserService;
import com.example.monthly.vo.DeliveryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;


// 로그인, 회원가입, 정보수정 등
@Controller
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    private final OrderService orderService;

    @GetMapping("/mypage")
    public void mypage(){

    }


    @GetMapping("/userModify")
    public String userModify(Long userNumber, Model model){
        //        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        userNumber = 74L;
        DeliveryVo user = userService.findAll(userNumber);
        model.addAttribute("user",user);
        return "user/userModify";
    }

    @PostMapping("/userModify")
    public String userModify(UserDto userDto, DeliveryDto deliveryDto, String checkPassword, HttpServletRequest req){
//        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
       userDto.setUserNumber(1L);
       userDto.setUserPassword(checkPassword);
       userService.updatePassword(userDto);

       //배송지 수정 (세션에서 받아온 userNumber 넣기)
       deliveryDto.setUserNumber(74L);

        System.out.println(deliveryDto);

       if(userService.findAll(74L).getDeliveryPostcode() != null){
           orderService.changeDelivery(deliveryDto);
       }else {
            orderService.registerDelivery(deliveryDto);

       }

        return "user/mypage";

    }

    @GetMapping("/changeStatus")
    public RedirectView userWithdraw(Long userNumber ,HttpServletRequest req){
//        Long userNumber = (Long) req.getSession().getAttribute("userNumber");
        userService.changeStatus(1L);
        return new RedirectView("/user/login");
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
