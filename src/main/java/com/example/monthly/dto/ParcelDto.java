package com.example.monthly.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ParcelDto {
//    이게 매달 나오는 배송주문
    private Long parcelNumber;
    private Long paymentNumber;
    private String parcelDate;
    private int parcelStatus;
    private String parcelInvoice;
    private String parcelCompany;
    private String deliveryPostcode;
    private String deliveryAddress1;
    private String deliveryAddress2;
}
