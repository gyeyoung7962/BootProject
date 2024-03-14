package com.example.springprj.service;

import com.example.springprj.domain.Board;
import com.example.springprj.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void insertBoard(Board board);
    public List<Board> listBoard();
    public Board readBoard(int board_no);
    public void updateViewCnt(int board_no);
    List<Board> listPaging(int page) throws Exception;
    List<Board> listCriteria(Criteria criteria) throws Exception;
    public int boardCount();
}
