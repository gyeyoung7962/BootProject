package com.example.springprj.service;

import com.example.springprj.domain.Doctor;
import com.example.springprj.repository.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {


    private final DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorMapper doctorMapper){
        this.doctorMapper = doctorMapper;
    }

    @Override
    public void insertDoctor(Doctor doctor) {

        doctorMapper.insertDoctor(doctor);
    }

    @Override
    public List<Doctor> doctorList() {

        return doctorMapper.doctorList();
    }

    @Override
    public List<Doctor> doctorList(String hospital_code) {

        return doctorMapper.doctorList(hospital_code);
    }


    @Override
    public Doctor login(String doctor_code, String doctor_pw) {

        return doctorMapper.login(doctor_code, doctor_pw);
    }


    @Override
    public int id_chk(String doctor_code) {

        return doctorMapper.id_chk(doctor_code);
    }

    @Override
    public Doctor doctorInfo(int doctor_no) {

        return doctorMapper.doctorInfo(doctor_no);
    }


    @Override
    public int doctorDelete(int doctor_no) {

        return doctorMapper.doctorDelete(doctor_no);
    }

    @Override
    public void doctorModify(Doctor doctor) {

        doctorMapper.doctorModify(doctor);

    }
}
