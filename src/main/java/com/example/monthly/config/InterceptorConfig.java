package com.example.monthly.config;

import com.example.monthly.interceptor.LoginInterceptor;
import com.example.monthly.interceptor.SellerLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final SellerLoginInterceptor sellerLoginInterceptor;
    private final LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        판매자 로그인 인터셉터 등록
        registry.addInterceptor(sellerLoginInterceptor)
                .addPathPatterns("/seller/*")
                .excludePathPatterns("/seller/login")
                .excludePathPatterns("/seller/apply")
                .excludePathPatterns("/seller/apDone");
//        관리자 로그인 인터셉터 등록

//        구매자 로그인 인터셉터 등록 (마이페이지, 정보수정, ..등?)
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/user/mypage")
                .addPathPatterns("/user/userModify")
                .addPathPatterns("/user/changeStatus")
                .addPathPatterns("/order/*");


    }


}
