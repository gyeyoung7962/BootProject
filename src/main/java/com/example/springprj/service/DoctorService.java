package com.example.springprj.service;

import com.example.springprj.domain.Doctor;
import com.example.springprj.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface DoctorService {

    public void insertDoctor(Doctor doctor, MultipartFile file) throws Exception; //프로필 이미지 회원가입

    public void insertDoctor(Doctor doctor); //이미지없이 회원가입
    public List<Doctor> doctorList(); //전체 의사 조회
    public List<Doctor> doctorList(String hospital_code); //병원코드로 의사조회
    public Doctor login(String doctor_code, String doctor_pw); //로그인
    public int id_chk(String doctor_code); //중복체크
    public Doctor doctorInfo(int doctor_no);//회원정보
    public void doctorDelete(int doctor_no,Doctor doctor); //회원탈퇴

    public void doctorDelete(int doctor_no); //회원탈퇴

    public void doctorModify(Doctor doctor, MultipartFile file) throws Exception; //회원 수정

    public void doctorModify(Doctor doctor) throws Exception;


}
