package com.example.demo.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rest_BasicController {

    @GetMapping("/restAPI/home")
    public String test0(){
        return "test/test_rest/home";
    }

    @GetMapping("/restAPI/test1")
    public String test1(){
        return "test/test_rest/test1";
    }
}
