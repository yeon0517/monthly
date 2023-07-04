package com.example.monthly.service.admin;

import com.example.monthly.dto.AdminDto;
import com.example.monthly.dto.SellerDto;
import com.example.monthly.mapper.AdminMapper;
import com.example.monthly.vo.SearchVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Slf4j
class AdminServiceTest {

    @Mock
    private AdminMapper adminMapper;
    @InjectMocks
    private AdminService adminService;
    private AdminDto adminDto;
    private SellerDto sellerDto;
    private SearchVo searchVo;


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
    void findAdminNumber() {
    }

    @Test
    void getSellerApplication() {
    }

    @Test
    void findAll() {
    }

    @Test
    void selectSeller() {

    }
}