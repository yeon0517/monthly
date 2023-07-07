package com.example.monthly.controller.admin;

import com.example.monthly.service.admin.AdminService;
import com.example.monthly.service.admin.AdminServiceSns;
import com.example.monthly.vo.AdminChartVo;
import com.example.monthly.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sms/v1/*")
@RequiredArgsConstructor
public class AdminSnsController {
    private final AdminServiceSns adminSnsService;

    @PostMapping("/send")
    public Mono<Map> sendMsg(@RequestBody Map<String, String> body){             //get이면 RequestbodyTmausdksehla json 형식으ㅢ body
        String phoneNumber = body.get("phoneNumber");
        return adminSnsService.sendMessage(phoneNumber);
    }
}
