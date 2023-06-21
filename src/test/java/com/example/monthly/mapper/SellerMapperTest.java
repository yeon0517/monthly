package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class SellerMapperTest {

    @Autowired
    private SellerMapper sellerMapper;
    private SellerDto sellerDto;

    @BeforeEach
    void setUp(){
        sellerDto = new SellerDto();
        sellerDto.setSellerName("바보야");
        sellerDto.setSellerId("ccc");
        sellerDto.setSellerPassword("1234");
        sellerDto.setSellerPhoneNumber("010-1234-1234");
        sellerDto.setSellerPostcode("11111");
        sellerDto.setSellerAddress1("서울시 강남구");
        sellerDto.setSellerAddress2("1-1");
        sellerDto.setSellerEmail("aaa@naver.com");
        sellerDto.setSellerCompanyRegisterNumber("1111");
        sellerDto.setSellerContents("메올");
    }

    @Test
    @DisplayName("판매자회원신청 & 판매자번호조회")
    void insert() {
        sellerMapper.insert(sellerDto);
        assertThat(sellerMapper.selectSellerNumber(sellerDto.getSellerId(), sellerDto.getSellerPassword()))
                .isEqualTo(sellerDto.getSellerNumber());
    }
    @Test
    void selectSellerNumber() {
    }
}
