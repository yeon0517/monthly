package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class SellerDto {
    private Long sellerNumber;
    private String sellerName;
    private String sellerId;
    private String sellerPassword;
    private String sellerPhoneNumber;
    private String sellerPostcode;
    private String sellerAddress1;
    private String sellerAddress2;
    private String sellerEmail;
    private String sellerContents;
    private String sellerCompanyRegisterNumber;
    private int sellerStatus;
    private String sellerRegisterDate;


}
