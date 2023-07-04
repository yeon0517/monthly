package com.example.monthly.service.user;

import com.example.monthly.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends UserService {

    @Override
    public void registerKakao(UserVo userVo) {
        // 받아온 카카오 로그인 정보를 UserVo에 맞게 설정
        userVo.setUserId(userVo.getId());
        userVo.setUserName(userVo.getNickname());
        userVo.setUserEmail(userVo.getEmail());
        userVo.setUserGender(userVo.getGender());
        userVo.setUserPhoneNumber(userVo.getMobile());
        userVo.setUserBirthday(userVo.getBirthday());

        // DB에 UserVo를 저장하는 로직을 구현
        // 예시로는 userMapper를 사용하여 UserVo를 DB에 저장하는 것으로 가정
        userMapper.insertUser(userVo);
    }
}
