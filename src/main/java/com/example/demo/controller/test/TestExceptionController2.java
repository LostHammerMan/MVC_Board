package com.example.demo.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TestExceptionController2 {

    @GetMapping("/test_exception2")
    public String test2(){

        ArrayList<String> list = null;
        list.add("문자열");

        return "test/test_exception/exception_test2";
    }

//    @ExceptionHandler(java.lang.NullPointerException.class)
//    public String exception2(){
//        return "test/test_exception/exception_error2";
//    }
}
