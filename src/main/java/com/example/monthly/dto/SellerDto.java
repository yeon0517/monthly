package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SellerDto {
    private Long sellerNumber;
    private String sellerName;
    private String sellerId;
    private String sellerPassword;
    private String sellerPhoneNumber;
    private String sellerAddress;
    private String sellerEmail;
    private String sellerContents;
    private Integer sellerCompanyRegisterNumber;
    private int sellerStatus;
    private String sellerRegistDate;
}
