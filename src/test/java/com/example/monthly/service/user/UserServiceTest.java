package com.example.monthly.service.user;

import com.example.monthly.dto.UserDto;
import com.example.monthly.mapper.UserMapper;
import com.example.monthly.vo.UserVo;
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
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private UserVo userVo;
    private UserDto userDto;

    @BeforeEach
    void setUp(){
        userVo = new UserVo();
        userVo.setUserId("aaa");
        userVo.setUserPassword("12346");
        userDto = new UserDto();
        userDto.setUserId("aaa");
        userDto.setUserPassword("12346");
        userMapper.insert(userVo);
    }

    @Test
    @DisplayName("회원 번호로 전체 조회")
    void findAll() {
        doReturn(userDto).when(userMapper).selectAll(any(Long.class));

        userService.findAll(1L);

        assertThat(userService.findAll(userDto.getUserNumber()).getUserId()).isEqualTo(userDto.getUserId());
    }

    @Test
    @DisplayName("비밀번호 업데이트")
    void updatePassword() {
        doNothing().when(userMapper).updatePassword(any(UserDto.class));

        userService.updatePassword(userDto);

        verify(userMapper,times(1)).updatePassword(userDto);
    }
}