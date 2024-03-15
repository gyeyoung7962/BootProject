package com.example.springprj.domain;

import lombok.Data;

import java.util.Date;

@Data
public class HDList {

    private int hospital_no; //병원번호
    private int doctor_no; //의사 번호
    private String doctor_name; //의사이름
    private String doctor_birth; //의사 생년월일
    private String hospital_code; //병원코드
    private String doctor_phone; //연락처
    private String doctor_career; //의사 경력사항
    private Date doctor_regDate; //의사가입일
    private String file_Path; //파일경로



}
