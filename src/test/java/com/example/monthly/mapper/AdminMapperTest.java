package com.example.monthly.mapper;

import com.example.monthly.dto.PaymentDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.AdminChartVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private SellerMapper sellerMapper;

    private SellerDto sellerDto;
    private AdminChartVo adminChartVo;
    private PaymentDto paymentDto;

    @BeforeEach
    void setUp() throws ParseException {
        sellerDto = new SellerDto();
        sellerDto.setSellerName("테스트이름1");
        sellerDto.setSellerStatus(1);
        sellerDto.setSellerId("test1");
        sellerDto.setSellerPhoneNumber("010-9956-8026");
        sellerDto.setSellerRegisterDate("2023-06-20");

        sellerDto.setSellerCompanyRegisterNumber("1231212345");
        sellerDto.setSellerEmail("nsoe12@naver.com");
        sellerDto.setSellerAddress1("서울특별시 서초구 반포대로 58. 101동 501호(서초동. 서초아파트)");
        //sellerMapper.insert(sellerDto);

        adminChartVo = new AdminChartVo();
       // adminChartVo.setSellerRegisterDate(sellerDto.getSellerRegisterDate());
        paymentDto = new PaymentDto();
        paymentDto.setPaymentNumber(1L);
        paymentDto.setPaymentPrice("9000");
        paymentDto.setPaymentStatus(1);
        paymentDto.setPaymentDate("2023-06-23");
        paymentDto.setUserNumber(1L);
        paymentDto.setProductNumber(1L);

        adminChartVo.setPaymentPrice(paymentDto.getPaymentPrice());
        adminChartVo.setPaymentStatus(paymentDto.getPaymentStatus());
        adminChartVo.setPaymentDate(paymentDto.getPaymentDate());

    }


    @Test
    void sellerApplication() {
        List<AdminChartVo> admin= adminMapper.sellerApplication();
        //log.info(admin.get(0).getRegistarionCount()+"===============================");
    }

    @Test
    void paymentCount() {
        List<AdminChartVo> adminChartList = adminMapper.paymentCount();
        for (AdminChartVo adminChart : adminChartList) {
            System.out.println(adminChart.getPaymentDate() + ": " + adminChart.getPaymentPriceCount());
        }
    }
}