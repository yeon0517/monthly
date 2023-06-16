package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DeliveryDto {
    private Long deliveryNumber;
    private Long userNumber;
    private String deliveryPostcode;
    private String deliveryAddress1;
    private String deliveryAddress2;
}
