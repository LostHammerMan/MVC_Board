package com.example.demo.dao;

import com.example.demo.domain.BoardInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopMenuInfoDao {

    public List<BoardInfoVO> getTopMenuList();


}
