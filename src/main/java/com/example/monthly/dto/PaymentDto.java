package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PaymentDto {
    private Long paymentNumber;
    private Long subsNumber;
    private Long cardNumber;
    private String paymentPrice;
    private String paymentDate;
    private int paymentStatus;
    private Long productNumber;
    private Long userNumber;
}
