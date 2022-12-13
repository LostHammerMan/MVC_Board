package com.example.demo.controller.test;

import com.example.demo.beans.Session_DataBean1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@SessionAttributes({"sessionBean1", "sessionBean2"}) // @ModelAttribute 으로 생성된 sessionBean1 이름의 빈을 session 영역에 저장
public class SessionScopeTestController {

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
}
