package com.example.monthly.mapper;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.vo.BrandFileVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class BrandFileMapperTest {

    @Autowired
    private BrandFileMapper brandFileMapper;

    private BrandFileVo brandFileVo;

    @Autowired
    private BrandMapper brandMapper;
    private BrandDto brandDto;

    @BeforeEach
    void setUp(){
        brandDto = new BrandDto();
        brandDto.setBrandName("testBrand");
        brandDto.setBrandContents("test");
        brandDto.setSellerNumber(15L);
        brandMapper.insertBrand(brandDto);

        brandFileVo = new BrandFileVo();
        brandFileVo.setSellerNumber(brandDto.getSellerNumber());
        brandFileVo.setBrandNumber(brandDto.getBrandNumber());
        brandFileVo.setBrandFileName("aaa");
        brandFileVo.setBrandFileUploadPath("/23/01/01");
        brandFileVo.setBrandFileUuid("uuid");

    }


    @Test
    void checkBrandFileExist() {
    }

    @Test
    @DisplayName("브랜드파일저장, 판매자번호로 브랜드파일조회")
    void insertBrandFile() {
        brandFileMapper.insertBrandFile(brandFileVo);
        assertThat(brandFileMapper.selectBrandFileBySellerNumber(brandDto.getSellerNumber())
                .getBrandFileName())
                .isEqualTo(brandFileVo.getBrandFileName());
    }

    @Test
    @DisplayName("브랜드파일 업데이트")
    void updateBrandFile() {
        brandFileMapper.insertBrandFile(brandFileVo);
        brandFileVo.setBrandFileName("updateTitle");
       brandFileMapper.updateBrandFile(brandFileVo);
        assertThat(brandFileMapper.selectBrandFileBySellerNumber(brandDto.getSellerNumber()).getBrandFileName())
                .isEqualTo(brandFileVo.getBrandFileName());
    }

    @Test
    @DisplayName("브랜드삭제, sellerNumber로 브랜드존재여부체크")
    void deleteBrandFile() {
        brandFileMapper.insertBrandFile(brandFileVo);
        brandFileMapper.deleteBrandFile(brandDto.getSellerNumber());
        assertThat(brandFileMapper.checkBrandFileExist(brandDto.getSellerNumber())).isEqualTo(0);
    }
}