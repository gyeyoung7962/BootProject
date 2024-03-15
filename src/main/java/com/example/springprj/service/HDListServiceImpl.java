package com.example.springprj.service;

import com.example.springprj.domain.HDList;
import com.example.springprj.repository.HDListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HDListServiceImpl implements HDListService {

    @Autowired
    private HDListMapper hdListMapper;
    @Override
    public void insertHDList(HDList hdList) {

        hdListMapper.insertHDList(hdList);
    }

    @Override
    public List<HDList> doctorList(int hospital_no) {

        return hdListMapper.doctorList(hospital_no);
    }


}
