package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SubsDto {
    private Long subsNumber;
    private Long userNumber;
    private Long productNumber;
    private String subsStartDate;
    private int subsStatus;
}
