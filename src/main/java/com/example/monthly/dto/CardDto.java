package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CardDto {
    private Long cardNumber;
    private Long userNumber;
    private String cardCompany;
    private String cardExpiredDate;
}
