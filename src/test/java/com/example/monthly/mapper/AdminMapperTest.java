package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.vo.AdminChartVo;
import com.example.monthly.vo.SearchVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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

    @BeforeEach
    void setUp(){
        sellerDto = new SellerDto();
        sellerDto.setSellerName("테스트이름1");
        sellerDto.setSellerStatus(1);
        sellerDto.setSellerPassword("aaa");
        sellerDto.setSellerId("test1");
        sellerDto.setSellerPhoneNumber("010-9956-8026");
        sellerDto.setSellerRegisterDate("2019/02/12");
        sellerDto.setSellerCompanyRegisterNumber("1231212345");
        sellerDto.setSellerEmail("nsoe12@naver.com");
        sellerDto.setSellerContents("12341234");
        sellerDto.setSellerPostcode("1234");
        sellerDto.setSellerAddress1("서울특별시 서초구 반포대로 58. 101동 501호(서초동. 서초아파트)");
        sellerDto.setSellerAddress2("1234주소2");


    }


    @Test
    void sellerApplication() {
        adminMapper.sellerApplication(adminChartVo.getSellerRegistertDate());
    }

    @Test
    void selectAll() {
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