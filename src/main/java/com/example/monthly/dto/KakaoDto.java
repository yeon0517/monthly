package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class KakaoDto {
    Long kakaoNumber;
    String merchantId;
    String customerId;
    String payDate;
    String cardName;
    String cardNumber;
    String impUid;
    String paidAmount;
    String pgType;
    Long userNumber;
}
