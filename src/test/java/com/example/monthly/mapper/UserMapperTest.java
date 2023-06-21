package com.example.monthly.mapper;

import com.example.monthly.dto.UserDto;
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
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setUserId("dkfsd97");
        userDto.setUserPassword("sdjfsd11");
        userDto.setUserName("케인");
        userDto.setUserPhoneNumber("512-5548-5485");
        userDto.setUserGender("M");
        userDto.setUserEmail("test@email.com");
        userDto.setUserBirthday("1993-09-08");
    }

    @Test
    @DisplayName("회원 가입 테스트")
    void insert() {
        userMapper.insert(userDto);
        assertThat(userMapper.selectUserNumber(userDto.getUserId(), userDto.getUserPassword()))
                .isEqualTo(userDto.getUserNumber());
    }



    @Test
    @DisplayName("회원 정보 검색")
    void selectAll() {
        userMapper.insert(userDto);

        log.info("===========출력=========" +userDto.toString());
       assertThat(userMapper.selectAll(userDto.getUserNumber()).getUserId()).isEqualTo(userDto.getUserId());
    }



    @Test
    void updatePassword(){
        userMapper.insert(userDto);

        userDto.setUserPassword("12345");

        userMapper.updatePassword(userDto);


        assertThat(userMapper.selectAll(userDto.getUserNumber()).getUserPassword()).isEqualTo("12345");
    }

    @Test
    void userWithdraw(){
        userMapper.insert(userDto);

        userMapper.userWithdraw(userDto.getUserNumber());

        assertThat(userMapper.selectAll(userDto.getUserNumber()).getUserStatus()).isEqualTo(0);
    }

}