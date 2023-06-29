package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class KakaoDto {
    private Long kakaoNumber;
    private String merchantId;
    private String customerId;
    private String payDate;
    private String cardName;
    private String cardNumber;
    private String impUid;
    private String paidAmount;
    private String pgType;
    private Long userNumber;
}
