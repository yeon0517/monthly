package com.example.monthly.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@NoArgsConstructor
public class AdminChartVo {
    private Date sellerRegistertDate;

}
