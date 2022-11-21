package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;

//    public UserService(UserDao userDao){
//        this.userDao = userDao;
//    }

    public int register(UserVO vo){

        return userDao.register(vo);
    }
}
