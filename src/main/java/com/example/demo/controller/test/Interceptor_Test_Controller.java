package com.example.demo.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Interceptor_Test_Controller {

    @GetMapping("/interceptor_home")
    public String test0(){
        return "test/test_interceptor/interceptor_home";
    }

    @GetMapping("/interceptor_test1")
    public String test1(){
        log.info("test1 called.....");
        return "test/test_interceptor/interceptor_test1";
    }

    @GetMapping("/interceptor_test2")
    public String test2(){
        log.info("test2 called.....");
        return "test/test_interceptor/interceptor_test2";
    }

    @GetMapping("/sub1/interceptor_test3")
    public String test3(){
        log.info("sub1/interceptor_test3 called......");
        return "test/test_interceptor/interceptor_test3";
    }

    @GetMapping("/sub1/interceptor_test4")
    public String test4(){
        log.info("sub1/interceptor_test4 called......");
        return "test/test_interceptor/interceptor_test4";
    }

}
