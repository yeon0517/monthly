package com.example.monthly.mapper;

import com.example.monthly.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;
    private ProductVo productVo;

    @Test
    void selectProduct() {
        ProductVo pro = productMapper.selectProduct(1L);

        assertThat(productMapper.selectProduct(1L).getProductName()).isEqualTo(pro.getProductName());
    }
}