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
    private String userId;
    private String userPassword;
    private String userName;
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
}
