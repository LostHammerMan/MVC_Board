package com.example.demo.controller.test;

import com.example.demo.beans.RestApi_DataBean1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class Rest_TestController {

    @GetMapping("/restAPI/test2")
    public ResponseEntity<ArrayList<RestApi_DataBean1>> test2(){

        RestApi_DataBean1 bean1 = new RestApi_DataBean1("문자열1", 100, 11.11, false);
        RestApi_DataBean1 bean2 = new RestApi_DataBean1("문자열2", 200, 22.22, true);
        RestApi_DataBean1 bean3 = new RestApi_DataBean1("문자열3", 300, 33.33, false);

        ArrayList<RestApi_DataBean1> list = new ArrayList<RestApi_DataBean1>();

        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        ResponseEntity<ArrayList<RestApi_DataBean1>> entry = new ResponseEntity<ArrayList<RestApi_DataBean1>>(list, HttpStatus.OK);

        return entry; // 리턴 값 자체가 응답결과
    }


}
