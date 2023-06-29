package com.example.monthly.controller.order;

import com.example.monthly.dto.CardDto;
import com.example.monthly.dto.KakaoDto;
import com.example.monthly.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders/*")
public class OrderRestController {

    private final OrderService orderService;
    private final CardDto cardDto = new CardDto();
    Random rand = new Random();

    @PostMapping("/payInfo")
    public String payInfo(@RequestBody KakaoDto kakaoDto, HttpServletRequest req){
        System.out.println(kakaoDto.toString()+"===============");
       Long userNumber =  (Long)req.getSession().getAttribute("userNumber");
        kakaoDto.setUserNumber(userNumber);
        orderService.kakapayRegister(kakaoDto);

        //카드 정보 입력
        String cardNumber = kakaoDto.getCardNumber();
        cardDto.setCardCompany(kakaoDto.getCardName());
//        테스트를 위해 원래 카드 번호에 다른 값을 임의로 붙여준다.
        cardDto.setCardNumber(cardNumber+rand.nextInt(10000));
        cardDto.setUserNumber(userNumber);
        orderService.cardRegister(cardDto);
        return "성공";

    }

}
