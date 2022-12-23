package com.example.demo.interceptor.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 복수 주소에서 작동하는 인터셉터
@Slf4j
public class TestInterceptor4 implements HandlerInterceptor {

    // Controller의 메서드가 실행되기 전 호출
    // false 반환 -> 요청 처리 진행 중단
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("TestInterceptor4 - preHandle called...");

        return true;
    }


    // Controller의 메서드가 호출된 후 호출
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("TestInterceptor4 - postHandle called...");
    }

    // view 처리까지 완료(응답결과 완료)되면 호출됨
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("TestInterceptor4 - afterCompletion called...");
    }
}
