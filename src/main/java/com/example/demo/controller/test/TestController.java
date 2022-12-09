//package com.example.demo.controller.test;
//
//import com.example.demo.domain.DataVO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Objects;
//
//@Slf4j
//@Controller
//public class TestController {
//
////    private DataVO dataVO;
////
////    public TestController(DataVO dataVO){
////        this.dataVO = dataVO;
////    }
//
//    @GetMapping("test")
//    public String test1(){
//
//        return "test/test";
//    }
//
////    @PostMapping("test33")
////    @ResponseBody
////    public String test2(@RequestBody DataVO dataVO){
////        log.info("{}", dataVO.toString());
////
////        return "success";
////    }
//
//    @PostMapping("test2")
//    @ResponseBody
//    public String test2(@RequestBody DataVO dataVO){
//        log.info("dataVO= " + dataVO.toString());
//        return dataVO.toString();
//    }
//}
