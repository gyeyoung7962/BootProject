package com.example.springprj.service;

import com.example.springprj.domain.Board;

import java.util.List;

public interface BoardService {

    public void insertBoard(Board board);
    public List<Board> listBoard();
    public Board readBoard(int board_no);

    public void updateViewCnt(int board_no);
}
