package com.example.demo.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class UserVO {



    private int user_idx;

    @Size(min = 2, max = 4)
    @Pattern(regexp = "[가-힣]*")
    @NotBlank
    private String user_name;

    @Size(min = 4, max = 12)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    @NotBlank
    private String user_id;

    @Size(min = 4, max = 16)
    @Pattern(regexp = "[ㄱ-ㅎa-zA-Z0-9]*")
    @NotBlank
    private String user_pw;

    @Size(min = 4, max = 16)
    @Pattern(regexp = "[ㄱ-ㅎa-zA-Z0-9]*")
    @NotBlank
    private String user_pw2;

    @Email(message = "옳바른 이메일 형식이 아닙니다")
    @NotBlank
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
