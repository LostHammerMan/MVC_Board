package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 웹 보안 활성화를 위한 annotation
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests() // 요청에 의한 보안검사 시작
                .anyRequest().authenticated() // 어떤 요청에도 보안검사 실시
            .and()
                .formLogin() // 보안 검증은 formLogin 방식으로 함
                .loginPage("user/login") // 로그인 성공 후 이동 페이지
                .defaultSuccessUrl("user/main") // 로그인 성공 후 이동 페이지
                .failureUrl("user/login_fail");
    }
}
