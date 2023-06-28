package com.example.monthly.mapper;

import com.example.monthly.dto.PaymentDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.AdminChartVo;
<<<<<<< HEAD
import lombok.Data;
=======
import com.example.monthly.vo.SearchVo;
>>>>>>> es/0623재클론
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> es/0623재클론
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
    private SearchVo searchVo;
    private SellerDto sellerDto;
    private AdminChartVo adminChartVo;
    private PaymentDto paymentDto;

    @BeforeEach
    void setUp() throws ParseException {
        sellerDto = new SellerDto();
        adminChartVo = new AdminChartVo();
        paymentDto = new PaymentDto();
        sellerDto.setSellerName("테스트이름1");
        sellerDto.setSellerStatus(1);
        sellerDto.setSellerPassword("aaa");
        sellerDto.setSellerId("test1");
        sellerDto.setSellerPhoneNumber("010-9956-8026");
        sellerDto.setSellerRegisterDate("2023-06-20");
        sellerDto.setSellerCompanyRegisterNumber("1231212345");
        sellerDto.setSellerEmail("nsoe12@naver.com");
        sellerDto.setSellerContents("12341234");
        sellerDto.setSellerPostcode("1234");
        sellerDto.setSellerAddress1("서울특별시 서초구 반포대로 58. 101동 501호(서초동. 서초아파트)");
        sellerDto.setSellerAddress2("1234주소2");
       // adminChartVo.setSellerRegisterDate(sellerDto.getSellerRegisterDate());
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

    @Test
    @DisplayName("동적쿼리 테스트 빈문자열로 해당 값들 조회하기")
    void selectSeller() {
        adminMapper.insert(sellerDto);
        searchVo = new SearchVo();
        searchVo.setPeriod("");
        searchVo.setSearchSelect("seller-Name");
        searchVo.setSearchInput("박은서5");
        List<SellerDto> list = adminMapper.selectSeller(searchVo);
        System.out.println(list);
    }
    @Test
    void update(){
        adminMapper.insert(sellerDto);
        sellerDto.setSellerStatus(3);
        adminMapper.update(sellerDto);

        System.out.println("==========================="+sellerDto);
    }
}