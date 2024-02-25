package com.example.springprj.repository;

import com.example.springprj.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {

    public void insertUser(User user);
    public List<User> userList();



}
