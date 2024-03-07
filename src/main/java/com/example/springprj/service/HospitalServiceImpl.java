package com.example.springprj.service;


import com.example.springprj.domain.Hospital;
import com.example.springprj.repository.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalMapper hospitalMapper;


    @Override
    public void insertHospital(Hospital hospital) throws Exception {

        hospitalMapper.insertHospital(hospital);

    }

    public void insertHospital(Hospital hospital, MultipartFile file) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/upload";

        String fileName = System.currentTimeMillis() + "_"+ file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        hospital.setFile_name(fileName);
        hospital.setFile_path("/upload/"+fileName);

        hospitalMapper.insertHospital(hospital);
    }

    @Override
    public Hospital hospitalInfo() {

        return hospitalMapper.hospitalInfo();
    }
}
