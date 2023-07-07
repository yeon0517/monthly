package com.example.monthly.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Long userNumber;
    private Long deliveryNumber;
    private String userId;
    private String userPassword;
    private String userName;
    private String userName1;
    private String userName2;
    private String userAddress;
    private String userPostcode;
    private String userAddress1;
    private String userAddress2;
    private String userPhoneNumber;
    private String userPhoneNumber1;
    private String userPhoneNumber2;
    private String userPhoneNumber3;
    private String userEmail;
    private String userGender;
    private String userBirthday;
    private String userBirthdayY;
    private String userBirthdayM;
    private String userBirthdayD;
    private int userStatus;
    private String subsStartDate; //관리자 전체 회원검색 은서가 추가
    private String productName; //관리자 전체 회원검색 은서가 추가
}
