package com.example.demo.service;

import com.example.demo.dao.TopMenuInfoDao;
import com.example.demo.domain.BoardInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TopMenuInfoService {

    @Autowired
    private TopMenuInfoDao topMenuInfoDao;

    public List<BoardInfoVO> getTopMenuList(){
        List<BoardInfoVO> topMenuList = topMenuInfoDao.getTopMenuList();
        log.info("{}", topMenuList);
        log.info("topMenuService called....");
        return topMenuList;
    }
}
