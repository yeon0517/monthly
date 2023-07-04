package com.example.monthly.service.user;

import com.example.monthly.dto.UserDto;
import com.example.monthly.mapper.UserMapper;
import com.example.monthly.vo.DeliveryVo;
import com.example.monthly.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserMapper userMapper;

    // 회원 가입
    public void register(UserVo userVo) {
        if (userVo == null) {
            throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음");
        }
        userMapper.insert(userVo);

        // 주소 입력란이 공백이 아닐 때만 주소를 추가
        if (!userVo.getUserPostcode().isEmpty() && !userVo.getUserAddress2().isEmpty()) {
            userMapper.insertAddress(userVo);
        }
    }


    // 회원 가입 아이디 중복 검사
    public int checkId(String userId) {
        return userMapper.checkId(userId);
    }


    //  아이디 찾기
    public UserVo findId(UserVo userVo) {
        if (userVo == null) {
            throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음");
        }
        return userMapper.findId(userVo);
    }

    //  비밀번호 찾기
    public UserVo findPw(UserVo userVo) {
        if (userVo == null) {
            throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음");
        }
        return userMapper.findPw(userVo);
    }

    /**
     * 회원 번호 조회, 로그인(아이디, 패스워드)
     *
     * @param userId
     * @param userPassword
     * @return
     * @throws IllegalArgumentException 존재하지 않는 회원 id, pw로 조회하는 경우
     */
    @Transactional(readOnly = true)
    public Long userLogin(String userId, String userPassword) {
        if (userId == null || userPassword == null) {
            throw new IllegalArgumentException("아이디, 패스워드 누락!");
        }
        return Optional.ofNullable(userMapper.userLogin(userId, userPassword))
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("존재하지 않는 회원입니다.");
                });
    }

    //회원번호로 회원 전체 조회
    public DeliveryVo findAll(Long userNumber) {
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return userMapper.selectAll(userNumber);
    }

    //비밀번호 수정
    public void updatePassword(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("비밀번호, 회원 번호 누락");
        }
        userMapper.updatePassword(userDto);
    }

    //회원 상태 변경
    public void changeStatus(Long userNumber) {
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        userMapper.userWithdraw(userNumber);
    }

    // 카카오 로그인 정보를 받아서 DB에 저장
    public void registerKakao(UserVo userVo) {
        // 받아온 카카오 로그인 정보를 UserVo에 맞게 설정
        userVo.setUserId(userVo.getUserId());
        userVo.setUserName(userVo.getUserName());
        userVo.setUserEmail(userVo.getUserEmail());
        userVo.setUserGender(userVo.getUserGender());
        userVo.setUserPhoneNumber(userVo.getUserPhoneNumber());
        userVo.setUserBirthday(userVo.getUserBirthday());

        // DB에 UserVo를 저장하는 로직을 구현
        // 예시로는 userMapper를 사용하여 UserVo를 DB에 저장하는 것으로 가정
        userMapper.insertKakaoUser(userVo);
    }
}