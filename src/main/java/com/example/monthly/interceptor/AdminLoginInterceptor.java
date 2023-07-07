package com.example.monthly.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
    Object adminNumber = request.getSession().getAttribute("adminNumber");
        System.out.println("========================="+adminNumber);
    if(adminNumber==null){
        response.sendRedirect("/seller/login");
        return false;
    }
    return true;
    }
}
