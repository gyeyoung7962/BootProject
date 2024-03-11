package com.example.springprj.repository;


import com.example.springprj.domain.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@Mapper
public interface HospitalMapper {

    public void insertHospital(Hospital hospital) throws Exception;

    public void insertHospital(Hospital hospital, MultipartFile file) throws Exception;

    public Hospital hospitalInfo(int hospital_no);

    public List<Hospital> hospitalList();











}
