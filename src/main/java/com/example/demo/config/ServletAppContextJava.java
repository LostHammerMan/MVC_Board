package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // SpringMVC 관련 설정
@ComponentScan("com.example.demo.beans")
public class ServletAppContextJava  {

}
