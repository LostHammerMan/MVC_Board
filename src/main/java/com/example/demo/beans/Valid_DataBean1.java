package com.example.demo.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
public class Valid_DataBean1 {

    @Size(min = 2, max = 10)
    private String data1;

    private String data2;

    private String data3;
}
