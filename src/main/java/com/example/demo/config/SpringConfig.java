package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // 에러메시지 properties 등록
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
//
//        // 에러 메시지 프로퍼티스의 이름과 위치 지정
//        res.setDefaultEncoding("UTF-8");
//        res.setBasename("static/properties/error_message_kr");
//        return res;
//    }
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setBasename("static/properties/error_message_kr");
        messageSource.setBasename("static/properties/error_message_ko");
        return messageSource;
    }


}
