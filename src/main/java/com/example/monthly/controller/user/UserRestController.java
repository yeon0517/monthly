package com.example.monthly.controller.user;

import com.example.monthly.service.user.UserService;
import com.example.monthly.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/*")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/checkId")
    public int checkId(String userId) {
        return userService.checkId(userId);
    }

    @PostMapping("/registerNaver")
    public ResponseEntity<String> registerNaverUser(@RequestBody UserVo userVo) {
        try {
            // 중복된 ID인 경우 에러 응답 반환
            if (userService.checkId(userVo.getUserId()) > 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 ID입니다.");
            }

            // 서버로부터 받은 네이버 사용자 정보를 UserService를 통해 처리
            userService.registerNaverUser(userVo);

            // 사용자 정보 처리 후, 필요한 로직을 수행하거나 적절한 응답을 반환합니다.
            return ResponseEntity.ok("Naver login information received and processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process Naver login information.");
        }
    }

    @PostMapping("/registerKakao")
    public ResponseEntity<String> registerKakaoUser(@RequestBody UserVo userVo) {
        try {
            // 중복된 ID인 경우 에러 응답 반환
            if (userService.checkId(userVo.getUserId()) > 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 ID입니다.");
            }

            // 카카오 사용자 정보를 UserService를 통해 처리
            userService.registerKakaoUser(userVo);

            // 사용자 정보 처리 후, 필요한 로직을 수행하거나 적절한 응답을 반환합니다.
            return ResponseEntity.ok("Kakao login information received and processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process Kakao login information.");
        }
    }
}
