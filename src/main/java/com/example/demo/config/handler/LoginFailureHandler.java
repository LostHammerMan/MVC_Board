package com.example.demo.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {



/*    @Value("loginId")
    private String loginId;

    @Value("loginPwd")
    private String loginPwd;

    @Value("ErrorMSG")
    private String errorMsgName; // 로그인 페이지에서 jstl을 이용해 에러메시지를 가져올 때 사용할 변수*/


    private final static String defaultFailureUrl = "/user/login"; // 실패시 보여줄 화면 URL

    // HttpServletRequest : 웹에서 넘어온 Request 값을 가지고 있는 객체
    // HttpServletResponse : c출력을 정의할 수 있는 객체
    // AuthenticationException : 로그인 실패 정보를 가지고 있는 객체

    // HttpServletRequest 객체를 이용해 웹에서 넘어오는 로그인 정보들을 메서드를 통해 가져옴
    // 가져온 값을 다시 setAttribute 해서 다시 웹으로 넘겨줌

    // AuthenticationException 객체를 통해 실패 메시지를 가져와 다시 셋팅하여 웹으로 보냄
    // 셋팅한 값들을 메서드(getRequestDispatcher_를 통해 보여줄 화면으로 foward해주면,
    // jstl 을 통해 보여줄 화면으로 forward

    //


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        String errorMsg = null;

        if (!StringUtils.hasText(user_id)){
            errorMsg = "아이디 입력 ㄱ";
        } else if (!StringUtils.hasText(user_pw)) {
            errorMsg = "비밀번호 입력 ㄱ";
        } else if (exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException) {
            errorMsg = "아이디, 비밀번호 다시 확인 ㄱ";
        } else {
            errorMsg = "알 수 없는 오류 발생함";
        }

        request.setAttribute("errorMsg", errorMsg);
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
/*
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");
        String errorMessage = null;

        log.info("{}", exception.toString());

        if (!StringUtils.hasText(id)) {
            errorMessage = "아이디를 입력해주세요.";
        } else if (!StringUtils.hasText(pw)) {
            errorMessage = "비밀번호를 입력해주세요.";
        } else if ((exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException)) {
            errorMessage = "아이디가 존재하지 않거나 비밀번호가 다릅니다.";
        } else {
            errorMessage = "알 수 없는 오류가 발생하였습니다.";
        }

        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher(defaultFailureUrl).forward(request, response);*/

      /*  String errorMessage;

        // error
        // 아이디 null
        // 비번 null
        // BadCredentialsException (아이디가 존재하지 않거나 비번이 다를 경우)

        if (exception instanceof BadCredentialsException){
            errorMessage = "아이디 비번 확인";
        } else if (exception instanceof UsernameNotFoundException) {
            errorMessage = "회원가입 ㄱㄱ";
        }else {
            errorMessage = "unknown issue";
        }
        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");
        setDefaultFailureUrl("/user/login?error=true&exception="+errorMessage);
        super.onAuthenticationFailure(request, response, exception);
*/
    }

}
