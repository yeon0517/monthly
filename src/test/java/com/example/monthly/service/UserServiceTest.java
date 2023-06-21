package com.example.monthly.service;

import com.example.monthly.dto.UserDto;
import com.example.monthly.mapper.UserMapper;
import com.example.monthly.service.user.UserService;
import com.example.monthly.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Transactional
@Slf4j
class UserServiceTest {
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private UserDto userDto;
    private UserVo userVo;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        userDto.setUserNumber(1L);
        userDto.setUserId("testId");
        userDto.setUserPassword("1234");
        userDto.setUserName("케인");
        userDto.setUserPhoneNumber("010-1234-1234");
        userDto.setUserGender("M");
        userDto.setUserEmail("test@email.com");
        userDto.setUserBirthday("1993-09-08");
        userDto.setUserStatus(1);
    }

    @Test
    @DisplayName("회원 가입 검사")
    void register() {
        doNothing().when(userMapper).insert(any(UserVo.class));

        userService.register(userVo);

        verify(userMapper, times(1)).insert(userVo);
    }

}