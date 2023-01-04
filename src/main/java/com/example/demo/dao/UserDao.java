package com.example.demo.dao;

import com.example.demo.domain.UserVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    // 회원 가입
    public int register(UserVO joinUserBean);

    // 중복 아이디 검사
    public String checkUserIdExist(String user_id);

    public UserVO getLoginUserInfo(UserVO tempLoginUserBean);

    // findBy 규칙 -> Username 문법
    // select * from user_table where user_id = #{user_id}
    public UserVO findByUserId(String user_id); // JPA Query Method

//    public void modifyUser(UserVO user);
    public int modifyUser(UserVO modifyUserBean);
}
