package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BrandFileDto {
    private Long brandFileNumber;
    private Long brandNumber;
    private String brandFileName;
    private String brandFileUploadPath;
    private String brandFileUuid;
}
