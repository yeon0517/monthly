package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.mapper.BrandMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@Slf4j
class BrandServiceTest {

    @Mock
    private BrandMapper brandMapper;
    @InjectMocks
    private BrandService brandService;

    private BrandDto brandDto;

    @BeforeEach
    void setUp(){
        brandDto = new BrandDto();
        brandDto.setBrandName("모어포모레");
        brandDto.setBrandContents("환경문제 해결을 적극적으로 기여하는 모레상점 기부 프로젝트");
        brandDto.setSellerNumber(17L);

    }

    @Test
    @DisplayName("brand 정보 없으면 최초저장")
    void saveBrandInfo() {
        doReturn(0).when(brandMapper).checkBrandExist(any(Long.class));
        doNothing().when(brandMapper).brandInsert(any(BrandDto.class));
        brandService.saveBrandInfo(brandDto);
        verify(brandMapper, times(1)).brandInsert(brandDto);
    }
    @Test
    @DisplayName("brand 정보 존재하면 업데이트")
    void saveBrandInfo2() {
        doReturn(1).when(brandMapper).checkBrandExist(any(Long.class));
        doNothing().when(brandMapper).brandUpdate(any(BrandDto.class));
        brandService.saveBrandInfo(brandDto);
        verify(brandMapper, times(1)).brandUpdate(brandDto);
    }

    @Test
    @DisplayName("브랜드정보조회")
    void findBrandInfo(){
        doReturn(brandDto).when(brandMapper).brandSelectBySellerNumber(any(Long.class));
        BrandDto foundBrand = brandService.findBrandInfo(14L);
        assertThat(foundBrand.getBrandName()).isEqualTo(brandDto.getBrandName());
    }



}