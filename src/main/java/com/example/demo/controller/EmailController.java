package com.example.demo.controller;

import com.example.demo.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class EmailController {

    @Autowired
    private MailService mailService;

    // 이메일 인증번호 전송
    @PostMapping("user/mailConfirm")
    @ResponseBody
    public String mailConfirm(@RequestParam(value = "email") String email, HttpSession session) throws Exception{
//    public String mailConfirm(@RequestBody String email, HttpSession session) throws Exception{

        log.info("email = " + email);
        String code = mailService.sendSimpleMessage(email);
        log.info("인증코드 : " + code);

        session.setAttribute("authCode", code);

        log.info("key=" + code);
        return code;
    }

    // 이메일 인증확인
    @ResponseBody
    @GetMapping("user/confirmEmailAuth")
    public ResponseEntity<String> confirmEmailAuth(@RequestParam("$memailConfirm") String memailConfirm, HttpSession session){

        log.info("confirmEmailAuth called.....");

        String msg = "";
        String authCode = (String) session.getAttribute("authCode");

        if (authCode.equals(memailConfirm)){
            msg = "authSuccess";
            session.removeAttribute("authCode");
        }else {
            msg = "authFail";
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }




}
