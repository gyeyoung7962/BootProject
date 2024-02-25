package com.example.springprj.domain;


import lombok.Data;

import java.util.Date;
import java.util.Random;

@Data
public class User {

    private int user_no; //회원번호
    private String user_name; //회원이름
    private String user_id; //회원아이디
    private String user_pw; //회원비밀번호
    private Date user_regDate; //회원가입일
    private int user_serialNo; //랜덤시리얼번호(차트번호에 사용할예정)
    private String user_birth; //생년월일
    private String user_phone; //연락처
    private String user_addr; //회원연락처

    Random random = new Random();

    int serialNo = (int)(random.nextInt()*1531)+1;


    public void setUser_addr(String postcode, String address, String detail) {
        this.user_addr = postcode + " " + address + " " + detail;
    }

    public User(){
        serialNo++;
        this.user_serialNo = serialNo;
    }
}
