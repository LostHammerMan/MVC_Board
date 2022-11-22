package com.example.demo.controller;

import com.example.demo.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class EmailController {

    @Autowired
    private MailService mailService;

    @PostMapping("user/mailConfirm")
    @ResponseBody
    public String mailConfirm(@RequestParam(value = "email") String email, HttpSession session) throws Exception{

        String code = mailService.sendSimpleMessage(email, session);
        log.info("인증코드 : " + code);
        return code;
    }
}
