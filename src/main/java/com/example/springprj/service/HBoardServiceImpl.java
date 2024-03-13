package com.example.springprj.service;

import com.example.springprj.domain.HBoard;
import com.example.springprj.repository.HBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HBoardServiceImpl implements HBoardService {


    @Autowired
    private HBoardMapper hBoardMapper;
    @Override
    public void insertHBoard(HBoard hBoard) {

        hBoardMapper.insertHBoard(hBoard);

    }

    @Override
    public List<HBoard> listHBoard(String hospital_code) {

        return hBoardMapper.listHBoard(hospital_code);
    }

    @Override
    public HBoard infoHBoard(String hospital_code, int hospital_no) {

        return hBoardMapper.infoHBoard(hospital_code, hospital_no);
    }
}
