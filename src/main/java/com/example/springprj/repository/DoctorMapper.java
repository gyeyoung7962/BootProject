package com.example.springprj.repository;


import com.example.springprj.domain.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DoctorMapper {

    public void insertDoctor(Doctor doctor);
    public List<Doctor> doctorList(); //소속없는 의사 조회
    public List<Doctor> doctorList(String hospital_code); //병원코드로 의사조회
    public Doctor login(String doctor_code, String doctor_pw); //로그인
    public int id_chk(String doctor_code); //중복체크
    public Doctor doctorInfo(int doctor_no);//회원정보
    public int doctorDelete(int doctor_no); //회원탈퇴
    public void doctorModify(Doctor doctor); //회원 수정
}
