package com.example.demo.interceptor;

import com.example.demo.domain.BoardInfoVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.TopMenuInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class TopMenuInterceptor implements HandlerInterceptor {

    @Autowired
    TopMenuInfoService topMenuInfoService;

    @Resource(name = "loginUserBean")
    private UserVO loginUserBean;

    public TopMenuInterceptor(TopMenuInfoService topMenuInfoService, UserVO loginUserBean){
        this.topMenuInfoService = topMenuInfoService;
        this.loginUserBean = loginUserBean;
    }



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        List<BoardInfoVO> topMenuList = topMenuInfoService.getTopMenuList();
        log.info("{}", topMenuList);
        request.setAttribute("topMenuList", topMenuList);
        request.setAttribute("loginUserBean", loginUserBean);
        return true;
    }
}
