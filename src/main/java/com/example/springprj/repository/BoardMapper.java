package com.example.springprj.repository;


import com.example.springprj.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    public void insertBoard(Board board);
    public List<Board> listBoard();
    public Board readBoard(int board_no);
    public void updateViewCnt(int board_no);
}
