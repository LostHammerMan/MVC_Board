package com.example.demo.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class TestExceptionController {

    @GetMapping("/exception_home")
    public String test0(){
        return "test/test_exception/exception_home";
    }

    @GetMapping("/test_exception1")
    public String test1(Model model){

//        int[] array1 = {10, 20, 30};
//        log.info("array1 = {}", array1[0]);
//
////        model.addAttribute("array1", array1[0]);
//        model.addAttribute("array1", array1[10]);

        ArrayList<String> list = null;
        list.add("문자열");

        return "test/test_exception/exception_test1";

    }



    // 배열의 길이가 넘어가는 오류 발생시 작동
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String exception1(){
        return "test/test_exception/exception_error1";
    }
}
