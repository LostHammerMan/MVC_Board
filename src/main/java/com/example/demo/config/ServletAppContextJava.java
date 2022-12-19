package com.example.demo.config;

import com.example.demo.interceptor.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // SpringMVC 관련 설정
@ComponentScan("com.example.demo.beans")
@ComponentScan("com.example.demo.exception")
public class ServletAppContextJava implements WebMvcConfigurer {

//    // 인터셉터 등록
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
//
//        // 인터셉터 객체 생성
//        TestInterceptor1 inter1 = new TestInterceptor1();
//        TestInterceptor3 inter3 = new TestInterceptor3();
//        TestInterceptor4 inter4 = new TestInterceptor4();
//        TestInterceptor5 inter5 = new TestInterceptor5();
//        TestInterceptor6 inter6 = new TestInterceptor6();
//        TestInterceptor7 inter7 = new TestInterceptor7();
//        TestInterceptor8 inter8 = new TestInterceptor8();
//
//        // 등록
//        InterceptorRegistration reg1 = registry.addInterceptor(inter1);
//        InterceptorRegistration reg3 = registry.addInterceptor(inter3);
//        InterceptorRegistration reg4 = registry.addInterceptor(inter4);
//        InterceptorRegistration reg5 = registry.addInterceptor(inter5);
//        InterceptorRegistration reg6 = registry.addInterceptor(inter6);
//        InterceptorRegistration reg7 = registry.addInterceptor(inter7);
//        InterceptorRegistration reg8 = registry.addInterceptor(inter8);
//
//        // 주소 세팅
//        reg1.addPathPatterns("/interceptor_test1");
//        reg3.addPathPatterns("/interceptor_test2");
//
//        // interceptor4 는 test1, test2 모두 반응하도록 설정
//        reg4.addPathPatterns("/interceptor_test1", "/interceptor_test2");
//
//        reg5.addPathPatterns("/sub1/interceptor_test3", "/sub1/interceptor_test4");
//
//        // 모든 주소 요청시 작동
//        reg6.addPathPatterns("/*"); // "/interceptor_test1" 작동, "/sub1/interceptor_test3" 작동 안함 --> "/*/*" 처리해야 작동
//
//        reg7.addPathPatterns("/sub1/*");
//
//        reg8.addPathPatterns("/**"); // 뒤에 어떤 요청이 와도 작동
//
//        // "/interceptor_test1" 경우는 제외
//        reg8.excludePathPatterns("/*");
//    }
}
