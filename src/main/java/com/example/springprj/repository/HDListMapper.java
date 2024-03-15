package com.example.springprj.repository;

import com.example.springprj.domain.HDList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface HDListMapper {

    public void insertHDList(HDList hdList);

    public List<HDList> doctorList(int hospital_no);



}
