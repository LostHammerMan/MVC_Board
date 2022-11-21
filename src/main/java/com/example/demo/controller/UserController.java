package com.example.demo.controller;

import com.example.demo.domain.Data;
import com.example.demo.domain.UserVO;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    public UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }
    @GetMapping("join")
    public String join(@ModelAttribute("joinUserVO") UserVO joinUserVO){
        return "user/join";
    }

    @PostMapping("join_ok")
    public String join_ok(@ModelAttribute("joinUserVO") UserVO joinUserVO, BindingResult result){
        if (result.hasErrors()){
            return "user/join";
        }
        userService.register(joinUserVO);
        log.info("join_ok........");
        return "user/join_ok";
    }

    @GetMapping("/login")
    public String login(){
        log.info("login called.....");
        return "user/login";
    }

    @GetMapping("logout")
    public String logout(){
        log.info("logout called...");
        return "user/logout";
    }

    @GetMapping("modify")
    public String modify(){
        log.info("modify called...");
        return "user/modify_user";
    }

    @GetMapping("/joinA")
    public String joinA() {
        log.info("joinA called..");
        return "user/join_a";
    }

    @PostMapping("/joinAPro")
    public String joinAPro(@ModelAttribute Data data) {
        log.info("joinAPro called..");
        return "user/join_a";
    }
    @GetMapping("/joinB")
    public String joinB(@ModelAttribute Data data) {
        log.info("joinB called..");
        return "user/join_b";
    }
    @PostMapping("/joinBPro")
    public String joinBPro(@ModelAttribute Data data) {
        log.info("joinBPro called..");
        return "user/join_b";
    }
}
