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
    public void register(UserVo userVo){
        if (userVo == null){ throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음"); }
        userMapper.insert(userVo);
    }

    // 회원 가입 아이디 중복 검사
    public int checkId(String userId){
        return userMapper.checkId(userId);
    }

    // 가입 후 기본 정보 출력
    @Transactional(readOnly = true)
    public UserDto showJoinInfo(UserDto userNumber) {
        return userMapper.showJoinInfo(userNumber);

    }

    //  아이디 찾기
    public void findId(UserVo userVo){
        if (userVo == null){ throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음"); }
        userMapper.findId(userVo);
    }

    //  비밀번호 찾기
    public void findPw(UserVo userVo){
        if (userVo == null){ throw new IllegalArgumentException("입력란 누락이나 조건이 충족되지 않음"); }
        userMapper.findPw(userVo);
    }

    /**
     * 회원 번호 조회, 로그인(아이디, 패스워드)
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
    public DeliveryVo findAll(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        return userMapper.selectAll(userNumber);
    }

    //비밀번호 수정
    public void updatePassword(UserDto userDto){
        if (userDto == null) {
            throw new IllegalArgumentException("비밀번호, 회원 번호 누락");
        }
        userMapper.updatePassword(userDto);
    }

    //회원 상태 변경
    public void changeStatus(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 번호 누락");
        }
        userMapper.userWithdraw(userNumber);
    }

}
