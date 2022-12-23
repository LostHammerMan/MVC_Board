package com.example.demo.controller;

import com.example.demo.domain.BoardInfoVO;
import com.example.demo.service.TopMenuInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequestMapping("/")
@Controller
public class MainController {

    @Autowired
    private TopMenuInfoService topMenuInfoService;

    @GetMapping("/main")
    public String main(Model model){
        log.info("main called....");

//        List<BoardInfoVO> board_list = topMenuInfoService.getTopMenuList();
//        model.addAttribute("board_list", board_list);
        return "index";
    }
}
