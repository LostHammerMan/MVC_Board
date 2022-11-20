package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("join")
    public String join(){
        return "user/join";
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
}
