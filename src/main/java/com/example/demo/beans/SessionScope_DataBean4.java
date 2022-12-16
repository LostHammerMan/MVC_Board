package com.example.demo.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component(value = "sessionScope_dataBean4")
@SessionScope
public class SessionScope_DataBean4 {

    private String data7;
    private String data8;
}
