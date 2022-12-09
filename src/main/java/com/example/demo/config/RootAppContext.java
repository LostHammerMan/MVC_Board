package com.example.demo.config;

import com.example.demo.domain.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

// 프로젝트 작업시 사용할 bean 정의
@Configuration
public class RootAppContext {

//    @SessionScope : 브라우저가 최초의 요청을 발생시키고 닫을 때까지
//    session 영역에 생성되어 있는 데이터나 객체 자유롭게 사용 가능

    @Bean("loginUserBean")
    @SessionScope
    public UserVO loginUserBean(){return new UserVO();}
}
