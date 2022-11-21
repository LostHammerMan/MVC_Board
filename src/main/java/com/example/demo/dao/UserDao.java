package com.example.demo.dao;

import com.example.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public int register(UserVO vo);
}
