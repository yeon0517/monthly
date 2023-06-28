package com.example.monthly.controller.order;

import com.example.monthly.service.board.ProductService;
import com.example.monthly.service.user.UserService;
import com.example.monthly.vo.DeliveryVo;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//주문, 결제, 배송 등과 관련
@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Slf4j
public class OrderController {

    private final UserService userService;
    private final ProductService productService;

    @GetMapping("/order")
    public String order(Long productNumber, String parcelDate, String cnt, HttpServletRequest req,Model model){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        DeliveryVo deliveryVo = userService.findAll(userNumber);
        ProductVo productVo = productService.productView(productNumber);
        model.addAttribute("delivery",deliveryVo);
        model.addAttribute("product",productVo);
        model.addAttribute("parcelDate",parcelDate);
        model.addAttribute("cnt",cnt);
        return "order/order";
    }

}
