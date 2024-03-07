package com.example.springprj.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Hospital {

    private int hospital_no; //병원번호
    private String hospital_name; //병원이름ㅇ
    private String hospital_medical; //진료과목ㅇ
    private String hospital_address; //병원주소ㅇ
    private String hospital_tel; //병원연락처ㅇ
    private String hospital_code; //병원코드ㅇ

    private String file_name; //사진이름
    private String file_path; //사진경로



    private String hospital_chart; //진료차트
    private int user_no; //회원번호
    private int doctor_no; //의사번호
    private int reservation_no;//예약번호
    private Date hospital_regDate; //병원가입일


    public void setHospital_address(String postcode, String address, String detail){
        this.hospital_address = postcode+ " " + address+ " " + detail;
    }



}
