package com.example.demo.dao;

import com.example.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    // 회원 가입
    public int register(UserVO joinUserBean);

    // 중복 아이디 검사
    public String checkUserIdExist(String user_id);

    public UserVO getLoginUserInfo(UserVO tempLoginUserBean);

}
