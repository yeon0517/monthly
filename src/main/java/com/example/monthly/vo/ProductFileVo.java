package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ProductFileVo {
    private Long brandFileNumber;
    private Long brandNumber;
    private String brandFileName;
    private String brandFileUploadPath;
    private String brandFileUuid;
    private String brandFileSize;

    private Long productFileNumber;
    private Long productNumber;
    private String productFileName;
    private String productFileUploadPath;
    private String productFileUuid;

    private Long sellerNumber; //파는사람 넘버
    private String brandName; //브랜드 이름
    private String brandContents; //브랜드 내용
    private String brandRegisterDate; //브랜드 등록일

    private String productName;
    private String productPrice;
    private Long productAmount;
    private String productContents;

    private int sellerStatus;

}
