package com.example.springprj.service;

import com.example.springprj.domain.Board;
import com.example.springprj.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService{


    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void insertBoard(Board board) {

        boardMapper.insertBoard(board);
    }
}
