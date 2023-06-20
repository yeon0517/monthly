package com.example.monthly.service.user;

import com.example.monthly.dto.UserDto;
import com.example.monthly.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserMapper userMapper;

    public void register(UserDto userDto){
        if (userDto == null){ throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음"); }
        userMapper.insert(userDto);
    }



}
