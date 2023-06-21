package com.example.monthly.service.seller;

import com.example.monthly.dto.SellerDto;
import com.example.monthly.mapper.SellerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class SellerServiceTest {

    @Mock
    private SellerMapper sellerMapper;
    @InjectMocks
    private SellerService sellerService;

    private SellerDto sellerDto;

    @BeforeEach
    void setUp(){
        sellerDto = new SellerDto();
        sellerDto.setSellerName("바보야");
        sellerDto.setSellerId("ccc");
        sellerDto.setSellerPassword("1234");
        sellerDto.setSellerPhoneNumber("010-1234-1234");
        sellerDto.setSellerPostcode("1234");
        sellerDto.setSellerAddress1("서울시 강남구");
        sellerDto.setSellerAddress2("1-1");
        sellerDto.setSellerEmail("aaa@naver.com");
        sellerDto.setSellerCompanyRegisterNumber("1111-1111");
        sellerDto.setSellerContents("메올");
    }
    @Test
    @DisplayName("판매자신청")
    void sellerApply() {
        doNothing().when(sellerMapper).insert(any(SellerDto.class));
        sellerService.sellerApply(sellerDto);
        verify(sellerMapper, times(1)).insert(sellerDto);
    }

    @Test
    @DisplayName("판매자로그인>판매자번호조회")
    void findSellerNumber() {
        doReturn(1L).when(sellerMapper).selectSellerNumber(any(String.class), any(String.class));
        Long sellerNumber = sellerService.findSellerNumber("test","1234");
        assertThat(sellerNumber).isEqualTo(1L);
    }

    @Test
    @DisplayName("판매자번호조회 : 존재하지 않는 회원 예외검사")
    void findSellerNumberException(){
        doReturn(null).when(sellerMapper).selectSellerNumber(any(String.class), any(String.class));
        assertThatThrownBy(() -> sellerService.findSellerNumber("test","1234"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("존재하지");
    }

    @Test@DisplayName("판매자 아이디 중복 검사")
    void sellerIdCheck(){
        doReturn(1).when(sellerMapper).selectId(any(String.class));
        int result = sellerService.sellerIdCheck("test");
        assertThat(result).isEqualTo(1);
    }
}