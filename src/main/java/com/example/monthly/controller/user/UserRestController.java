package com.example.monthly.controller.user;

import com.example.monthly.service.user.UserService;
import com.example.monthly.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/checkId")
    public int checkId(String userId){
        return userService.checkId(userId);
    }

    @PostMapping("/registerKakao")
    public void registerKakao(@RequestBody UserVo userVo) {
        // Kakao 로그인 정보를 받아서 UserVo에 맞게 데이터 설정
        // userService를 사용하여 UserVo를 DB에 저장
        userService.registerKakao(userVo);
    }
}
