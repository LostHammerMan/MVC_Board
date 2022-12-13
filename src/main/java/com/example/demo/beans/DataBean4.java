package com.example.demo.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "requestBean4") // requestBean4 이름으로 빈 등록됨
@RequestScope
@Getter
@Setter
public class DataBean4 {

    private String data7;
    private String data8;
}
