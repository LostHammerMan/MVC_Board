package com.example.demo.controller.test;

import com.example.demo.beans.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@SessionAttributes({"sessionBean1", "sessionBean2"}) // @ModelAttribute 으로 생성된 sessionBean1 이름의 빈을 session 영역에 저장
public class SessionScopeTestController {

    @Autowired
    SessionScope_DataBean1 sessionScope_dataBean1;

    @Resource(name = "sessionScope_dataBean2")
    SessionScope_DataBean2 sessionScope_dataBean2;

    @Autowired
    SessionScope_DataBean3 sessionScope_dataBean3;

    @Resource(name = "sessionScope_dataBean4")
    SessionScope_DataBean4 sessionScope_dataBean4;

    @ModelAttribute("sessionBean1")
    public Session_DataBean1 sessionBean1(){
        return new Session_DataBean1();
    }

    @ModelAttribute("sessionBean2")
    public Session_DataBean1 sessionBean2(){
        return new Session_DataBean1();
    }

    @GetMapping("/test_sessionScope")
//    public String test1(HttpServletRequest request){
      public String test1(HttpSession session){
//        HttpSession session = request.getSession();
        session.setAttribute("data1", "문자열1");
        return "test/sessionScope_test";
    }

    @GetMapping("/test_sessionScope_result")
//    public String result1(HttpServletRequest request){
    public String result1(HttpSession session){

//        HttpSession session = request.getSession();
        String data1 = (String) session.getAttribute("data1");
        log.info("data1 = {}", data1);

        return "test/session_result";
    }

    @GetMapping("/test_sessionScope2")
    public String test2(HttpSession session){
        session.setAttribute("data1", "문자열2");
        return "redirect:/test_sessionScope_result";
    }

    @GetMapping("/test_sessionScope3")
    public String test3(HttpSession session){
        session.setAttribute("data1", "문자열3");
        return "forward:/test_sessionScope_result";
    }

    @GetMapping("/test_sessionScope4")
    public String test4(HttpSession session){
//    public String test4(@SessionAttribute("bean1") Session_DataBean1 bean1){
        Session_DataBean1 bean1 = new Session_DataBean1();
        bean1.setData1("문자열4");
        bean1.setData2("문자열5");

//        session.setAttribute("bean1", bean1);
        return "test/sessionScope_test4";
    }

    @GetMapping("/test_sessionScope_result4")
//    public String result4(HttpSession session){
    public String result4(@SessionAttribute("bean1") Session_DataBean1 bean1){
//        Session_DataBean1 bean1 = (Session_DataBean1) session.getAttribute("bean1");

        log.info("bean1.data1= {}", bean1.getData1());
        log.info("bean1.data2= {}", bean1.getData2());

        return "test/test_sessionScope_result4";
    }

    @GetMapping("/test_sessionScope5")
    public String test5(@ModelAttribute("sessionBean1") Session_DataBean1 sessionBean1,
                        @ModelAttribute("sessionBean2") Session_DataBean1 sessionBean2){
        sessionBean1.setData1("문자열6");
        sessionBean1.setData2("문자열7");

        return "test/test_sessionScope5";
    }

    @GetMapping("/test_sessionScope_result5")
    public String result5(@ModelAttribute("sessionBean1") Session_DataBean1 sessionBean1){
        log.info("sessionBean1.data1 = {}", sessionBean1.getData1());
        log.info("sessionBean1.data2 = {}", sessionBean1.getData2());

        return "test/test_sessionScope_result5";
    }

    // SessionScope Bean 주입
    @GetMapping("/test_session_bean1")
    public String test6(){
        sessionScope_dataBean1.setData1("data1");
        sessionScope_dataBean1.setData2("data2");

        sessionScope_dataBean2.setData3("data3");
        sessionScope_dataBean2.setData4("data4");

        sessionScope_dataBean3.setData5("data5");
        sessionScope_dataBean3.setData6("data6");

        sessionScope_dataBean4.setData7("data7");
        sessionScope_dataBean4.setData8("data8");


        return "test/test_session_bean1";
    }

    @GetMapping("/test_session_bean1_result1")
    public String result6(Model model){
        log.info("sessionScope_dataBean1.data1 = {}", sessionScope_dataBean1.getData1());
        log.info("sessionScope_dataBean1.data2 = {}", sessionScope_dataBean1.getData2());
        log.info("sessionScope_dataBean2.data3 = {}", sessionScope_dataBean2.getData3());
        log.info("sessionScope_dataBean2.data4 = {}", sessionScope_dataBean2.getData4());
        log.info("sessionScope_dataBean3.data5 = {}", sessionScope_dataBean3.getData5());
        log.info("sessionScope_dataBean3.data6 = {}", sessionScope_dataBean3.getData6());
        log.info("sessionScope_dataBean4.data7 = {}", sessionScope_dataBean4.getData7());
        log.info("sessionScope_dataBean4.data8 = {}", sessionScope_dataBean4.getData8());

        model.addAttribute("sessionScope_dataBean1", sessionScope_dataBean1);
        model.addAttribute("sessionScope_dataBean2", sessionScope_dataBean2);
        model.addAttribute("sessionScope_dataBean3", sessionScope_dataBean3);
        model.addAttribute("sessionScope_dataBean4", sessionScope_dataBean4);

        return "test/test_session_bean1_result1";
    }
}
