package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReviewDto {
    private Long reviewNumber;
    private Long productNumber;
    private Long userNumber;
    private String reviewContents;
    private String reviewDate;
}
