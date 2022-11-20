package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("board")
@Controller
public class BoardController {

    @GetMapping("/main")
    public String board_main(){
        return "board/board_main";
    }
}
