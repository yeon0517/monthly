package com.example.monthly.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class DeliveryVo {
    private Long userNumber;
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhoneNumber;
    private String userEmail;
    private String userGender;
    private String userBirthday;
    private int userStatus;
    private Long deliveryNumber;
    private String deliveryPostcode;
    private String deliveryAddress1;
    private String deliveryAddress2;

}
