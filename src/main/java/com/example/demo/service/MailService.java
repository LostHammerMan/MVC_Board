package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Random;

@Service
public class MailService {

    @Autowired
    private  JavaMailSender emailSender;

    private String epw; // 인증번호

    // 메일 내용 작성
    public MimeMessage createMessage(String to) throws Exception{

        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, to); // 보내는 대상
        message.setSubject("Board_demo 회원가입 인증");

        String msg = "";

        msg += "<div style='margin:100px;'>";
        msg += "<h1>안녕</h1>";
        msg += "<br>";
        msg += "<div align='center' style='boarder:1px solid black; font-family:verdana';>";
        msg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msg += "CODE : <Strong>";
        msg += epw + "</strong></div><br>"; // 메일에 인증번호 추가
        msg += "</div>";

        message.setText(msg, "utf-8", "html");

        // 보내는 사람의 이메일 주소, 이름
        message.setFrom(new InternetAddress("board_demo@naver.com", "demoMan"));
        return message;
    }

    // 랜덤 인증 코드 전송
    public String createKey(){
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();
        String final_key = "";

        for(int i=0; i < 8; i++){
            int index = rnd.nextInt(3); // 0~2 까지 랜덤, rnd 값에 따라 switch 문

            switch (index)
            {
                case 0 :
                    key.append((char) ((int)rnd.nextInt(26)) + 97);
                    // a ~ z ex. 1 + 97 = 98 --> (char) 98 = 'b'
                    break;

                case 1 :
                    key.append((char) ((int)rnd.nextInt(26)) + 65);
                    break;

                case 2 :
                    key.append((rnd.nextInt(10)));
                    break;
            }
        }
        final_key = key.toString();
        return final_key;
    }

    // 메일 발송
    public String sendSimpleMessage(String to, HttpSession session) throws Exception{
        epw = createKey(); // 랜덤 인증번호 생성

        MimeMessage message = createMessage(to);

        try {
            emailSender.send(message); // 메일 전송
            session.setAttribute("epw", epw);
        }catch (MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }

        return epw;
    }


}
