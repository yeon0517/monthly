package com.example.monthly.mapper;

import com.example.monthly.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(UserDto userDto);

    UserDto selectAll(Long userNumber);

    void updatePassword(UserDto userDto);

    void userWithdraw(Long userNumber);

}
