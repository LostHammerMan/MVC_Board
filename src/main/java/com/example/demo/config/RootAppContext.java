package com.example.demo.config;

import com.example.demo.beans.DataBean1;
import com.example.demo.beans.DataBean2;
import com.example.demo.beans.SessionScope_DataBean1;
import com.example.demo.beans.SessionScope_DataBean2;
import com.example.demo.domain.UserVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;

// 프로젝트 작업시 사용할 bean 정의
@Configuration
public class RootAppContext {

//    @SessionScope : 브라우저가 최초의 요청을 발생시키고 닫을 때까지
//    session 영역에 생성되어 있는 데이터나 객체 자유롭게 사용 가능

    @Bean("loginUserBean")
    @SessionScope
    public UserVO loginUserBean(){return new UserVO();}

    // 새로운 요청이 생겼을 때 아래 빈 생성
    @Bean
    @RequestScope
    public DataBean1 dataBean1(){
        return new DataBean1();
    }

    @Bean("requestBean2")
    @RequestScope
    public DataBean2 dataBean2(){
        return new DataBean2();
    }

    @Bean
    @SessionScope
    public SessionScope_DataBean1 sessionScope_dataBean1(){
        return new SessionScope_DataBean1();
    }

    @Bean("sessionScope_dataBean2")
    @SessionScope
    public SessionScope_DataBean2 sessionScope_dataBean2(){
        return new SessionScope_DataBean2();
    }
}
