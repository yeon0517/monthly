package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ProductVo {
    private Long productNumber;
    private Long brandNumber;
    private String productName;
    private String productPrice;
    private Long productAmount;
    private String productContents;
    private String productOption;
    private String productRegisterDate;
    private int productStatus;
    private String brandName; //브랜드 이름
}
