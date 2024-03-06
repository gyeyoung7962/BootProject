package com.example.springprj.service;


import com.example.springprj.domain.Hospital;
import com.example.springprj.repository.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;


    @Override
    public void insertHospital(Hospital hospital) throws Exception {

        hospitalMapper.insertHospital(hospital);

    }
}
