package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@NoArgsConstructor
public class AdminChartVo {
    private String sellerRegisterDate;
    private int registrationCount;

//    월간 매출 차트를 위한
    private String paymentPrice;
    private String paymentDate;
    private int paymentStatus;
    private int paymentPriceCount;

}
