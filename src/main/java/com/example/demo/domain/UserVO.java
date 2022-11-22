package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {

    private int user_idx;
    private String user_name;
    private String user_id;
    private String user_pw;
    private String user_email;
    private String zipcode;
    private String user_addr;
    private String user_detail_addr;
    private String user_goal;
    private String certificationNumber;

}
