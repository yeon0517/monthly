package com.example.monthly.controller.order;

import com.example.monthly.dto.ParcelDto;
import com.example.monthly.dto.PaymentDto;
import com.example.monthly.dto.SubsDto;
import com.example.monthly.service.board.ProductService;
import com.example.monthly.service.order.OrderService;
import com.example.monthly.service.user.UserService;
import com.example.monthly.vo.DeliveryVo;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

//주문, 결제, 배송 등과 관련
@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Slf4j
public class OrderController {

    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;
    private final SubsDto subsDto= new SubsDto();
    private final PaymentDto paymentDto = new PaymentDto();
    private final ParcelDto parcelDto = new ParcelDto();
    Random rand = new Random();

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

    @PostMapping("/subs")
    public String subs(@Param("productNumber") Long productNumber, HttpServletRequest req, @Param("inputPrice") String inputPrice,
                             @Param("cardNumber") String cardNumber, String parcelDate, DeliveryVo deliveryVo, String productAmount){

        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        //구독 추가
        subsDto.setProductNumber(productNumber);
        subsDto.setUserNumber(userNumber);
        System.out.println(subsDto.toString()+"구독 정보 입력=====================");
        orderService.subsRegister(subsDto);

        //상품 수량 빼기
        System.out.println("주문한 상품 수량"+productAmount);
        ProductVo productVo = productService.productView(productNumber);
        Long amount = productVo.getProductAmount() - Integer.valueOf(productAmount);
        System.out.println("남은 재고 수량++++++++++++++++++="+amount);
        productVo.setProductAmount(amount);
        productService.amountChange(productVo);

        //결제 정보
        SubsDto subs = orderService.subsFindAll(userNumber,productNumber);
        Long subsNumber = subs.getSubsNumber();
        paymentDto.setSubsNumber(subsNumber);
        paymentDto.setPaymentPrice(inputPrice);
        paymentDto.setUserNumber(userNumber);
        paymentDto.setProductNumber(productNumber);
        paymentDto.setCardNumber(cardNumber);
        System.out.println(paymentDto.toString()+"결제 정보 출력 ==================================");
        orderService.paymentRegister(paymentDto);



        //배송 주문
        parcelDto.setParcelDate(parcelDate);
        parcelDto.setDeliveryPostcode(deliveryVo.getDeliveryPostcode());
        parcelDto.setDeliveryAddress1(deliveryVo.getDeliveryAddress1());
        parcelDto.setDeliveryAddress2(deliveryVo.getDeliveryAddress2());
        Long paymentNumber = orderService.payCardFind(productNumber,userNumber);
        parcelDto.setPaymentNumber(paymentNumber);
        parcelDto.setParcelInvoice(""+rand.nextInt(10000000));
        System.out.println(parcelDto.toString() +"배송주문장 풀력 ============================================");
        orderService.parcelRegister(parcelDto);
        return "redirect:/user/mypage";
    }

}
