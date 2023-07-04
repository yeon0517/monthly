package com.example.monthly.mapper;

import com.example.monthly.dto.ProductDto;
import com.example.monthly.vo.Criteria;
import com.example.monthly.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;
    private ProductVo productVo;
    private ProductDto productDto;
    private Criteria criteria;

    @BeforeEach
    void setUp(){
        productDto = new ProductDto();
        productDto.setProductName("test1");
        productDto.setProductAmount(111L);
        productDto.setProductPrice("19000");
        productDto.setProductOption("option1");
        productDto.setProductContents("test");
        productDto.setBrandNumber(3L);
        productMapper.insertProduct(productDto);
    }
    @Test
    void selectProduct() {
        ProductVo pro = productMapper.selectProduct(1L);

        assertThat(productMapper.selectProduct(1L).getProductName()).isEqualTo(pro.getProductName());
    }

    @Test
    void insertProduct(){
        ProductVo foundProduct = productMapper.selectProduct(productDto.getProductNumber());
        assertThat(productMapper.selectProduct(productDto.getProductNumber()).getProductName())
                .isEqualTo(foundProduct.getProductName());
    }

    @Test
    void update(){
        productDto.setProductOption("option2");
        productDto.setProductName("test2");

        productMapper.updateProduct(productDto);
        assertThat(productMapper.selectProduct(productDto.getProductNumber()).getProductName())
                .isEqualTo("test2");

    }

    @Test
    void selectAll(){
        List<ProductVo> foundList =  productMapper.selectListPage(new Criteria(1,10),3L);
        assertThat(productMapper.selectTotal(3L))
                .isEqualTo(foundList.stream().count());
    }
}