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
}
