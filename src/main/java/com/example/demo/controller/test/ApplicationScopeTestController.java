package com.example.demo.controller.test;

import com.example.demo.beans.ApplicationScope_DataBean1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class ApplicationScopeTestController {

    @Autowired
    ServletContext application;

    @GetMapping("/test_ApplicationScope1")
    public String test1(HttpServletRequest request){

//        ServletContext application = request.getServletContext();
        application.setAttribute("data1", "문자열1");
        ApplicationScope_DataBean1  bean1 = new ApplicationScope_DataBean1();
        bean1.setData1("data1");
        bean1.setData2("data2");

        application.setAttribute("bean1", bean1);

        return "test/test_ApplicationScope1";
    }

    @GetMapping("/test_ApplicationScope1_result1")
    public String result1(HttpServletRequest request){

//        ServletContext application = request.getServletContext();
        String data1 = (String) application.getAttribute("data1");
        log.info("data1 = {}", data1);
        ApplicationScope_DataBean1 bean1 = (ApplicationScope_DataBean1) application.getAttribute("bean1");
        log.info("bean1.data1 = {}", bean1.getData1());
        log.info("bean1.data2 = {}", bean1.getData2());

        return "test/test_ApplicationScope1_result1";
    }
}
