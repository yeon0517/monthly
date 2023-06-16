package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BrandDto {
    private Long brandNumber;
    private Long sellerNumber;
    private String brandName;
    private String brandContents;
    private String brandRegistDate;
}
