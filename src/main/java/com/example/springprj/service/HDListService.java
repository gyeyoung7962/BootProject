package com.example.springprj.service;

import com.example.springprj.domain.HDList;

import java.util.List;

public interface HDListService {

    public void insertHDList(HDList hdList);

    public List<HDList> doctorList(int hospital_no);
}
