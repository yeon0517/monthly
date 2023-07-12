package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class SubsVo {
    private Long productNumber;
    private String productName;
    private String productPrice;
    private Long productFileNumber;
    private String productFileName;
    private String productFileUploadPath;
    private String productFileUuid;
    private Long subsNumber;
    private Long userNumber;
    private String subsStartDate;
    private String paymentPrice;
    private int subsStatus;
    private String userName; //구독자 이름 은서가 추가
    private String userId; //구독자 id 은서가 추가
    private Long brandNumber; //구독된 브랜드 불러오기 은서가 추가
    private String userPhoneNumber; // 유저 핸드폰 번호 승연 추가
}
