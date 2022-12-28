package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // 패스워드 암호화
    @Bean // 해당 메서드의 리턴되는 오브젝트롤 IoC로 등록
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("security called.........");
        http.csrf().disable();
        http.authorizeRequests()
//                .antMatchers("/user/**").authenticated() // /user/** url에 접근하기 위해서는 인증필요
                .antMatchers("/board/**").authenticated()
//                .antMatchers("/manager/**").access("hasRole('Role_Admin') or hasRole('Role_Manager')") // /manager/** URL에 접근하기 위해서는 Role_admin, Role_Manager 권한 필요
                .anyRequest().permitAll() // 그 외 요청은 모두 허용
                .and()
                .formLogin()
                    .loginPage("/user/login") // 인증실패 후 이동할 로그인 URL
                    .loginProcessingUrl("/user/login_pro") // login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인 진행 -> Controller에 login_pro mapping 할 필요 없음
                    .defaultSuccessUrl("/") // 로그인 성공시 메인 페이지로 이동
                .usernameParameter("user_id")
                .passwordParameter("user_pw");


    }
}
