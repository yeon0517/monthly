package com.example.monthly.mapper;

import com.example.monthly.dto.UserDto;
import com.example.monthly.vo.DeliveryVo;
import com.example.monthly.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserMapper {
    // 회원가입
    public void insert(UserVo userVo);

    // 회원가입 아이디 중복 검사
    public int checkId(String userId);

    // 로그인
    public Long userLogin(@Param("userId")String userId,
                                 @Param("userPassword")String userPassword);

    // 아이디 찾기
    public UserVo findId(UserVo userVo);

    // 비밀번호 찾기
    public UserVo findPw(UserVo userVo);


    DeliveryVo selectAll(Long userNumber);

    void updatePassword(UserDto userDto);

    void userWithdraw(Long userNumber);




}
