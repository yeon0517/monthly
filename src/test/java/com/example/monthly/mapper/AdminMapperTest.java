package com.example.monthly.mapper;

import com.example.monthly.dto.SellerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

    private SellerDto sellerDto;

    @BeforeEach
    void setUp(){
        sellerDto = new SellerDto();
        sellerDto.setSellerName("테스트이름1");
        sellerDto.setSellerStatus(1);
        sellerDto.setSellerId("test1");
        sellerDto.setSellerPhoneNumber("010-9956-8026");
        sellerDto.setSellerRegisterDate("2019/02/12");
        sellerDto.setSellerCompanyRegisterNumber("1231212345");
        sellerDto.setSellerEmail("nsoe12@naver.com");
        sellerDto.setSellerAddress("서울특별시 서초구 반포대로 58. 101동 501호(서초동. 서초아파트)");
//        adminMapper.insert(sellerDto);

    }

    @Test
    void insert() {
        adminMapper.insert(sellerDto);
        assertThat(adminMapper.selectSellerNumber(sellerDto.getSellerId(),sellerDto.getSellerName()))
                .isEqualTo(sellerDto.getSellerNumber());

    }

    @Test
    void selectSellerNumber() {
    }

    @Test
    void selectAll() {
    }
}