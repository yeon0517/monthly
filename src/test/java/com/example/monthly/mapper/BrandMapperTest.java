package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.SellerDto;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    private BrandDto brandDto;

    @BeforeEach
    void setUp(){
        brandDto = new BrandDto();
        brandDto.setBrandName("샘크래프트");
        brandDto.setBrandContents("종이용기 립밥");
        brandDto.setSellerNumber(15L);

    }

    @Test
    @DisplayName("브랜드 등록 및 판매자번호로 브랜드 조회")
    void brandInsert() {
        brandMapper.brandInsert(brandDto);
        assertThat(brandMapper.brandSelect(brandDto.getSellerNumber()).getBrandNumber())
        .isEqualTo(brandDto.getBrandNumber());

    }
    @Test
    void brandSelect() {
    }


    @Test
    void brandUpdate() {

    }

    @Test
    void brandSelectAll() {
    }

}