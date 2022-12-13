package com.example.demo.controller.test;

import com.example.demo.beans.DataBean1;
import com.example.demo.beans.DataBean2;
import com.example.demo.beans.DataBean3;
import com.example.demo.beans.DataBean4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Slf4j
@Controller
public class TestController_Bean_Java {


    // 새로운 요청이 왔을 때 빈 주입
    @Autowired
    DataBean1 requestBean1;

    @Resource(name = "requestBean2")
    DataBean2 requestBean2;

    @Autowired
    DataBean3 requestBean3;

    @Resource(name = "requestBean4")
    DataBean4 requestBean4;

    @GetMapping("/test_bean")
    public String test0(){
        return "test/test_bean";
    }

    @GetMapping("/test_Bean_java")
    public String test1(){

        requestBean1.setData1("문자열1");
        requestBean1.setData2("문자열2");
        requestBean2.setData3("문자열3");
        requestBean2.setData4("문자열4");
        requestBean3.setData5("문자열5");
        requestBean3.setData6("문자열6");
        requestBean4.setData7("문자열7");
        requestBean4.setData8("문자열8");
        // forward를 통한 요청은 새로운 요청을 발생시키지 않음
        // 새로운 객체가 주입되지 않고, 기존 객체 그대로 사용 -> request 영역에 저장되지 않음
        return "forward:/result_bean1";
    }

    @GetMapping("/result_bean1")
    public String result1(Model model){
        log.info("requestBean1.data1 = {}", requestBean1.getData1());
        log.info("requestBean1.data2 = {}", requestBean1.getData2());
        log.info("requestBean2.data3 = {}", requestBean2.getData3());
        log.info("requestBean2.data4 = {}", requestBean2.getData4());
        log.info("requestBean3.data5 = {}", requestBean3.getData5());
        log.info("requestBean3.data6 = {}", requestBean3.getData6());
        log.info("requestBean4.data7 = {}", requestBean4.getData7());
        log.info("requestBean4.data8 = {}", requestBean4.getData8());

        model.addAttribute("requestBean1", requestBean1);
        model.addAttribute("requestBean2", requestBean2);
        model.addAttribute("requestBean3", requestBean3);
        model.addAttribute("requestBean4", requestBean4);

        return "test/result_bean1";
    }

}
