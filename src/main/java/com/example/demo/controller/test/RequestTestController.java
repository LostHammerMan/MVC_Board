package com.example.demo.controller.test;

import com.example.demo.beans.DataBean1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class RequestTestController {

    @GetMapping("/request/index")
    public String test0(){
        return "test/requestTest";
    }

    @GetMapping("/request/test1")
    public String test1(HttpServletRequest request){
        request.setAttribute("data1", "문자열1");
//        return "redirect:/request/result1";
        return "forward:/request/result1";
    }

    @GetMapping("/request/result1")
    public String result1(HttpServletRequest request){
        String data1 = (String) request.getAttribute("data1");
        log.info("data1 ={}", data1);
        return "test/result1";
    }

    @GetMapping("/request/test2")
    public String test2(Model model){

        // Model에 저장되는 것이 아닌 request 객체에 저장됨
        model.addAttribute("data2", "문자열2");
        return "forward:/request/result2";
    }

    @GetMapping("/request/result2")
    public String result2(HttpServletRequest request){

        //
//        String data2 = (String) model.getAttribute("data2");
        // 위 데이터는 request 객체에 저장되므로, HttpServletRequest를 통해 데이터 추출 가능
        String data2 = (String) request.getAttribute("data2");
        log.info("data2 = {}", data2);
        return "test/result2_1";

    }

    @GetMapping("/request/test3")
    public ModelAndView test3(ModelAndView mv){
        mv.addObject("data3", "문자열3");
        mv.setViewName("forward:/request/result3");

        return mv;
    }

    @GetMapping("/request/result3")
    public String result3(HttpServletRequest request){
        String data3 = (String) request.getAttribute("data3");
        log.info("data3 = {}", data3);
        return "test/result3";
    }

    // 객체 전달
    @GetMapping("/request/test4")
    public String test4(Model model){
        DataBean1 bean1 = new DataBean1();
        bean1.setData1("문자열4");
        bean1.setData2("문자열5");

        model.addAttribute("bean1", bean1);
        return "forward:/request/result4";
    }
    @GetMapping("/request/result4")
    public String result4(HttpServletRequest request){

        DataBean1 bean1 = (DataBean1) request.getAttribute("bean1");
        log.info("bean1.data1 = {}", bean1.getData1());
        log.info("bean1.data2 = {}", bean1.getData2());

        return "test/result4";
    }

    @GetMapping("/request/test5")
    public String test5(@ModelAttribute("bean1") DataBean1 bean1){
        bean1.setData1("문자열6");
        bean1.setData2("문자열7");

//        return "test/test5";
        return "forward:/request/result5";
    }

    @GetMapping("/request/result5")
//    public String result5(@ModelAttribute("bean1") DataBean1 bean1){
    public String result5(HttpServletRequest request){
        DataBean1 bean1 = (DataBean1) request.getAttribute("bean1");
        log.info("bean1.data1 = {}", bean1.getData1());
        log.info("bean1.data2 = {}", bean1.getData2());
        return "test/result5";
    }


}
