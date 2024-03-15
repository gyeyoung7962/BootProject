package com.example.springprj.service;

import com.example.springprj.domain.Hospital;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HospitalService {

    public void insertHospital(Hospital hospital) throws Exception;

    public void insertHospital(Hospital hospital, MultipartFile file) throws Exception;

    public Hospital hospitalInfo(int hospital_no);
    public List<Hospital> hospitalList();


}
