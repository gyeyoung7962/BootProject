package com.example.springprj.repository;


import com.example.springprj.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {

    public void insertBoard(Board board);
}
