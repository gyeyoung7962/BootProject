package com.example.springprj.service;

import com.example.springprj.domain.Board;
import com.example.springprj.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BoardServiceImpl implements BoardService{


    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void insertBoard(Board board) {

        boardMapper.insertBoard(board);
    }

    @Override
    public List<Board> listBoard() {

        return boardMapper.listBoard();
    }

    @Override
    @Transactional
    public Board readBoard(int board_no) {

        return boardMapper.readBoard(board_no);
    }

    @Override
    public void updateViewCnt(int board_no) {

        boardMapper.updateViewCnt(board_no);
    }
}
