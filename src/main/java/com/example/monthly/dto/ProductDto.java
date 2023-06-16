package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProductDto {
    private Long productNumber;
    private Long brandNumber;
    private String productName;
    private String productPrice;
    private Long productAmount;
    private String productContents;
    private String productOption;
    private String productRegisterDate;
    private int productStatus;
}
