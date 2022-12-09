package com.example.demo.controller.test;

import com.example.demo.domain.DataBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class TestController_getObj {

    @GetMapping("/test1")
    public String test1(){
        return "test/result2";
    }

    @GetMapping("/test2")
    public String test2(@RequestParam Map<String, String> map, @RequestParam List<String> data3, Model model){
        String data1 = map.get("data1");
        String data2 = map.get("data2");
        String data33 = map.get("data3");

        log.info("data1 =" + data1);
        log.info("data2 =" + data2);
        log.info("data33 =" + data33);

        for (String str : data3){
            log.info("data3 = " + str);
        }

        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);
        model.addAttribute("data3", data3);

        return "test/result2";

    }

    @GetMapping("/test3")
    public String test3(@ModelAttribute("bean1") DataBean bean1){
        log.info("data1 = " + bean1.getData1());
        log.info("data2 = " + bean1.getData2());

        for (int number1 : bean1.getData3()){
            log.info("data3 =" + number1);
        }
        return "test/result2";
    }
}
