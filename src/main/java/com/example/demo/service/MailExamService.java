//package com.example.demo.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.mail.MailException;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import javax.mail.Message;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Random;
//
//@Service
//@Slf4j
//public class MailExamService {
//
//    private JavaMailSender emailSender;
//
//    // 인증번호
//    private String authNum;
//
//    public MailExamService(JavaMailSender emailSender) {
//        this.emailSender = emailSender;
//    }
//
//    // 메일 내용 작성
//    public MimeMessage createMessage(String to) throws Exception{
//        MimeMessage message = emailSender.createMimeMessage();
//
//        message.addRecipients(Message.RecipientType.TO, to); // 받는 대상
//        message.setSubject("이것은 연습입니다.");
//
//        String msg = "";
//
//        msg += "<div style='margin:100px;'>";
//        msg += "<h1>안녕</h1>";
//        msg += "<br>";
//        msg += "<div align='center' style='boarder:1px solid black; font-family:verdana';>";
//        msg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
//        msg += "CODE : <Strong>";
//        msg += authNum + "</strong></div><br>"; // 메일에 인증번호 추가
//        msg += "</div>";
//
//        message.setText(msg, "utf-8", "html");
//
//        // 보내는 사람의 이메일 주소, 이름
//        message.setFrom(new InternetAddress("exam@naver.com"));
//        return message;
//    }
//
//    /* 랜덤 인증코드 만들기*/
//    public String createAuthKey(){
//        Random random = new Random();
//        StringBuffer key = new StringBuffer();
//        String final_key = "";
//        // 예상 : 1111 ~ 9999
////        key = random.nextInt(8888) + 1111;
//        key.append(random.nextInt(8888) + 1111);
//        final_key = key.toString();
//
//        return final_key;
//    }
//
//    // 메일 발송 메서드
//    public String sendEmailMessage(String to) throws Exception {
//
//        // 인증번호 생성
//        authNum = createAuthKey();
//
//        // 메시지 생성
//        MimeMessage message = createMessage(to);
//
//        try {
//            emailSender.send(message);
//
//        }catch (MailException es){
//            es.printStackTrace();
//            throw new IllegalArgumentException();
//        }
//        log.info("authNum = " + authNum);
//        return authNum;
//    }
//
//
//}
