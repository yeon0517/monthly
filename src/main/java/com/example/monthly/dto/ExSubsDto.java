package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ExSubsDto {
    private Long exSubsNumber;
    private Long userNumber;
    private String exSubsName;
    private String exSubsDate;
    private String exSubsPrice;
}
