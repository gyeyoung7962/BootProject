package com.example.springprj.repository;


import com.example.springprj.domain.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HospitalMapper {

    public void insertHospital(Hospital hospital) throws Exception;





}
