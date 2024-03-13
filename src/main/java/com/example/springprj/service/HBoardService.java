package com.example.springprj.service;

import com.example.springprj.domain.HBoard;

import java.util.List;

public interface HBoardService {

    public void insertHBoard(HBoard hBoard);

    public List<HBoard> listHBoard(String hospital_code);

    public HBoard infoHBoard(String hospital_code, int hospital_no);
}
