package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.SellerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class BrandMapperTest {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private SellerMapper sellerMapper;

    private BrandDto brandDto;
    private SellerDto sellerDto;

    @BeforeEach
    void setUp(){

        brandDto = new BrandDto();
        brandDto.setBrandName("모어포모레");
        brandDto.setBrandContents("환경문제 해결을 적극적으로 기여하는 모레상점 기부 프로젝트");
        brandDto.setBrandRegisterDate("20230619");
        brandDto.setSellerNumber(sellerDto.getSellerNumber());
        brandMapper.brandInsert(brandDto);

    }

    @Test
    void brandInsert(){

    }

}