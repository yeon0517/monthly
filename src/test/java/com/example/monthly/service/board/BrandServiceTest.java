package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.mapper.BrandMapper;
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
        brandDto.setBrandRegisterDate("20230620");
        brandDto.setSellerNumber(1L);
        brandMapper.brandInsert(brandDto);

    }

    @Test
    @DisplayName("brand등록")
    void register() {
        doNothing().when(brandMapper).brandInsert(any(BrandDto.class));

        brandService.register(brandDto);

        verify(brandMapper, times(1)).brandInsert(brandDto);
    }
}