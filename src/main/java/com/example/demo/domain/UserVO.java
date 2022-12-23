package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
public class UserVO {

    // join

    // login
    // user_id, user_pw
    // user_name, user_pw2, user_email

    private int user_idx;

    private String user_name;
    private String user_id;
    private String user_pw;

    private String user_pw2;
    private String user_email;

//    @Pattern(regexp = "[0-9]")
    private String zipcode;

//    @Pattern(regexp = "[가-힣]*")
    private String user_addr;

//    @Pattern(regexp = "[가-힣]*")
    private String user_detail_addr;
    private String user_goal;
//    private String certificationNumber;

    // 중복 검사
    public boolean userIdExist;

    // 로그인 여부
    private boolean userLogin;

    public UserVO(){
        this.userIdExist = false;
        this.userLogin = false;
    }



}
