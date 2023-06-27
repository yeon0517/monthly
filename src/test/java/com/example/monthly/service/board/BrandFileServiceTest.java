package com.example.monthly.service.board;

import com.example.monthly.dto.BrandDto;
import com.example.monthly.dto.BrandFileDto;
import com.example.monthly.mapper.BrandFileMapper;
import com.example.monthly.vo.BrandFileVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@Slf4j
class BrandFileServiceTest {

    @Mock
    private BrandFileMapper brandFileMapper;
    @InjectMocks
    private BrandFileService brandFileService;
    private BrandFileVo brandFileVo;
    private BrandFileDto brandFileDto;

    @BeforeEach
    void setUp(){
        brandFileDto = new BrandFileDto();

        brandFileVo = new BrandFileVo();
        brandFileVo.setBrandFileName("testName");
        brandFileVo.setBrandFileUploadPath("23/01/01");
        brandFileVo.setBrandFileUuid("testUuid");
        brandFileVo.setSellerNumber(17L);
        brandFileVo.setBrandNumber(27L);
        brandFileVo.setBrandFileSize("long");
    }
    @Test
    @DisplayName("브랜드사진최초등록")
    void register() {
       doNothing().when(brandFileMapper).insertBrandFile(any(BrandFileVo.class));
       brandFileService.register(brandFileVo);
       verify(brandFileMapper, times(1)).insertBrandFile(brandFileVo);
    }

    @Test
    @DisplayName("브랜드사진업데이트")
    void register2(){

       doReturn(1).when(brandFileMapper).checkBrandFileExist(any(Long.class));
       doNothing().when(brandFileMapper).updateBrandFile(any(BrandFileVo.class));

       brandFileVo.setBrandFileName("change");
       brandFileService.register(brandFileVo);
       verify(brandFileMapper, times(1)).updateBrandFile(brandFileVo);
    }

    @Test
    void remove() {
    }

    @Test
    void findBrandFile() {
        doReturn(brandFileDto).when(brandFileMapper).selectBrandFileBySellerNumber(any(Long.class));
        BrandFileDto foundBrandFile = brandFileService.findBrandFile(1L);
        assertThat(foundBrandFile).isEqualTo(brandFileDto);
    }

    @Test
    void saveBrandFile() {
    }

    @Test
    void registerAndSaveBrandFile() {
    }
}