package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ProductVo {
    private Long productNumber;
    private Long brandNumber;
    private Long sellerNumber;//판매자 번호 은서가 추가
    private Long userNumber;//유저 번호 은서가 추가
    private int userNumberCount;//구독자수 카운트 은서가 추가
    private int subsNumberCount;//구독자수 카운트 은서가 추가
    private String productName;
    private String productPrice;
    private Long productAmount;
    private String productContents;
    private String productOption;
    private String productRegisterDate;
    private int productStatus;
    private String brandName; //브랜드 이름
    private String sellerPhoneNumber; //판매자 연락처 은서가 추가
    private String sellerEmail; //판매자 이메일 은서가 추가
    private String sellerName; //판매자 이름 은서가 추가

    private String searchInput; // 승연 검색기능으로 추가
}
