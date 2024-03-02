package com.example.springprj.service;

import com.example.springprj.domain.Doctor;
import com.example.springprj.domain.User;

import java.util.List;

public interface DoctorService {

    public void insertDoctor(Doctor doctor);
    public List<Doctor> doctorList(); //소속없는 의사 조회
    public List<Doctor> doctorList(String hospital_code); //병원코드로 의사조회
    public Doctor login(String doctor_code, String doctor_pw); //로그인
    public int id_chk(String doctor_code); //중복체크
    public Doctor doctorInfo(int doctor_no);//회원정보
    public int doctorDelete(int doctor_no); //회원탈퇴
    public void doctorModify(Doctor doctor); //회원 수정


}
