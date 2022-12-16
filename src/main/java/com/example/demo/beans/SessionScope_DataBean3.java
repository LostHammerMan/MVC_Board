package com.example.demo.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class SessionScope_DataBean3 {

    private String data5;
    private String data6;
}
