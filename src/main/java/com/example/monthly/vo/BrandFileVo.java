package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class BrandFileVo {
    private Long brandFileNumber;
    private Long brandNumber;
    private String brandFileName;
    private String brandFileUploadPath;
    private String brandFileUuid;
    private String brandFileSize;
    private Long sellerNumber;

    private String brandName; //브랜드 이름
    private String brandContents; //브랜드 내용
    private int sellerStatus;


}
