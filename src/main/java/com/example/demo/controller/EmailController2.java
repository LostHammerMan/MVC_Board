//package com.example.demo.controller;
//
//import com.example.demo.service.MailExamService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@Slf4j
//public class EmailController2 {
//
//    @Autowired
//    private MailExamService exam;
//
//    @GetMapping("emailSendExam")
//    public String emailSendExam(){
//        return "user/join3";
//    }
//
//    // 이메일 인증번호 전송
//    @PostMapping("emailSendExam")
//    @ResponseBody
//    public String emailSendExam(@RequestParam(value = "$email") String email, HttpSession session) throws Exception {
//
//        String code = exam.sendEmailMessage(email);
//        log.info("code = " + code);
//        session.setAttribute("authCode", code);
//
//
//        return code;
//    }
//
//    // 인증 확인
//    @GetMapping("authConfirm")
//    @ResponseBody
//    public ResponseEntity<String> confirmAuth(@RequestParam("$emailAuth") String emailAuth, HttpSession session){
//        String msg = "";
//        String authCode = (String) session.getAttribute("authCode");
//
//        if (authCode.equals(emailAuth)){
//            msg = "success";
//            session.removeAttribute("authCode");
//            return new ResponseEntity<>(msg, HttpStatus.OK);
//        }else{
//            msg = "fail";
//            return new ResponseEntity<>(msg, HttpStatus.OK);
//        }
//    }
//}
