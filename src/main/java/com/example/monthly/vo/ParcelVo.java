package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class ParcelVo {
    private Long parcelNumber;
    private String parcelDate;
    private int parcelStatus;
    private String parcelInvoice;
    private String parcelCompany;
    private Long paymentNumber;
    private String deliveryAddress1;
    private String deliveryAddress2;
    private String deliveryPostcode;
    private String paymentPrice;
    private int paymentStatus;
    private Long productNumber;
    private String productName;
    private String productOption;
    private Long userNumber;
    private String userName;
    private String userPhoneNumber;
    private Long brandNumber;
}
