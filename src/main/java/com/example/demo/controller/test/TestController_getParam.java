package com.example.demo.controller.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TestController_getParam {

//    @GetMapping("/test5")
//    public String test1(HttpServletRequest request) throws Exception{
//
//        String data1 = request.getParameter("data1");
//        String data2 = request.getParameter("data2");
//
//        log.info("data1 = " + data1);
//        log.info("data2 = " + data2);
//        return "test/result";
//    }
//
//    @PostMapping("/test6")
//    public String test2(HttpServletRequest request){
//
//        String data1 = request.getParameter("data1");
//        String data2 = request.getParameter("data2");
//        String[] data3 = request.getParameterValues("data3");
//
//        log.info("data1 = " + data1);
//        log.info("data2 = " + data2);
//
//        if (data3 != null){
//            for (String str2 : data3){
//                log.info("data3 = " + str2);
//            }
//        }
//
//        return "test/result";
//    }
//
//    @GetMapping("/test5/{data1}/{data2}/{data3}")
//    public String str4(@PathVariable String data1, @PathVariable String data2,
//                        @PathVariable String data3){
//
//        return "test/result";
//    }

    @GetMapping("/test5")
    public String test6(@RequestParam int data1,
                        @RequestParam int data2){

        return "test/result";
    }
}
