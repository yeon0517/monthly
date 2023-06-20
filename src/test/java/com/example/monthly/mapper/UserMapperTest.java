package com.example.monthly.mapper;

import com.example.monthly.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
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
    void setUp(){
     userDto = new UserDto();
     userDto.setUserId("aaa");
     userDto.setUserPassword("12345");
     userDto.setUserName("홍길동");
     userDto.setUserEmail("test@naver.com");
     userDto.setUserBirthday("2000-12-12");
     userDto.setUserGender("F");
     userDto.setUserPhoneNumber("010-1234-1234");

    }

    @Test
    @DisplayName("회원 정보 검색")
    void selectAll() {
        userMapper.insert(userDto);

        log.info("===========출력=========" +userDto.toString());
       assertThat(userMapper.selectAll(userDto.getUserNumber()).getUserId()).isEqualTo(userDto.getUserId());
    }

    @Test
    @DisplayName("회원 등록")
    void insert(){
        userMapper.insert(userDto);


       assertThat(userMapper.selectAll(userDto.getUserNumber())).isEqualTo(userDto.getUserId());
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