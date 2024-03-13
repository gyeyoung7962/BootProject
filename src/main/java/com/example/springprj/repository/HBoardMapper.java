package com.example.springprj.repository;


import com.example.springprj.domain.HBoard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HBoardMapper {

    public void insertHBoard(HBoard hBoard);

    public List<HBoard> listHBoard(String hospital_code);

    public HBoard infoHBoard(String hospital_code, int hospital_no);
}
