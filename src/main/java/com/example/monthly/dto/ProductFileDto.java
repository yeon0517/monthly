package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ProductFileDto {
    private Long productFileNumber;
    private Long productNumber;
    private String productFileName;
    private String productFileUploadPath;
    private String productFileUuid;
}
