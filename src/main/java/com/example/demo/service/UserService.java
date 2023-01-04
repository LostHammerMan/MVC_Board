package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.Principal;

@Slf4j
@Service
public class UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource(name = "loginUserBean")
    private UserVO loginUserBean;

//    public UserService(UserDao userDao){
//        this.userDao = userDao;
//    }

    public void register(UserVO joinUserBean){

        String rawPwd = joinUserBean.getUser_pw();
        String encPwd = bCryptPasswordEncoder.encode(rawPwd);
        log.info("encPwd = {}", encPwd);
        joinUserBean.setUser_pw(encPwd);


        userDao.register(joinUserBean);
    }

    public boolean checkUserIdExist(String user_id){
        String user_name = userDao.checkUserIdExist(user_id);

        if (user_name == null){
            return true;
        }else {
            return false;
        }
    }

    // 로그인
    public void getLoginUserInfo(UserVO tempLoginUserBean){
        log.info("service_getLoginUserInfo called");
        UserVO tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);

        if (tempLoginUserBean2 != null){
            loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
            loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
            loginUserBean.setUserLogin(true);

        }

    }

    // 회원정보 수정
    public void modifyUser(UserVO modifyUserBean, Principal principal){

        String rawPwd = modifyUserBean.getUser_pw();
        String encPwd = bCryptPasswordEncoder.encode(rawPwd);
        modifyUserBean.setUser_pw(encPwd);
        String  user_id = principal.getName();
        modifyUserBean.setUser_id(user_id);

        userDao.modifyUser(modifyUserBean);

    }
}
