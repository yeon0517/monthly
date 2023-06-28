package com.example.monthly.controller.user;

import com.example.monthly.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


}