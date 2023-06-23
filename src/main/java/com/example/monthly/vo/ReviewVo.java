package com.example.monthly.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ReviewVo {
    private Long reviewNumber;
    private Long productNumber;
    private Long userNumber;
    private String reviewContents;
    private String reviewUpdateDate;
    private String reviewRegisterDate;
    private String userId;
}
