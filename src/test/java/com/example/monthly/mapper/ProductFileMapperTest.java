package com.example.monthly.mapper;

import com.example.monthly.dto.ProductFileDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class ProductFileMapperTest {

    @Autowired
    private ProductFileMapper productFileMapper;

    @Test
    @DisplayName("제품 번호로 파일 조회")
    void proFileSelect() {
        List<ProductFileDto> pro = productFileMapper.proFileSelect(1L);
        log.info(pro.toString());
    }
}