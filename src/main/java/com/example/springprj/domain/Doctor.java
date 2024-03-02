package com.example.springprj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class Doctor {

    private int doctor_no; //의사번호
    private String doctor_name; //의사이름
    private String doctor_birth; //의사 생년월일
    private String doctor_code; //의사코드
    private String hospital_code; //병원코드
    private String doctor_pw; //의사 비밀번호
    private String doctor_phone; //연락처
    private String doctor_career; //의사 경력사항
    private Date doctor_regDate; //의사가입일
    private String doctor_pic; //사진
}
