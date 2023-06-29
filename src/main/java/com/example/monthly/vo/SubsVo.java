package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class SubsVo {
    private Long productNumber;
    private String productName;
    private String productPrice;
    private Long productFileNumber;
    private String productFileName;
    private String productFileUploadPath;
    private String productFileUuid;
    private Long subsNumber;
    private Long userNumber;
    private String subsStartDate;
    private String paymentPrice;
    private int subsStatus;
}
