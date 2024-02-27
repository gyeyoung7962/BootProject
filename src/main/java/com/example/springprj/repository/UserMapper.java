package com.example.springprj.repository;

import com.example.springprj.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper {

    public void insertUser(User user); //회원가입
    public List<User> userList(); //목록
    public User login(String user_id, String user_pw); //로그인
    public int id_chk(String user_id); //중복체크
    public User userInfo(int user_no);//회원정보
    public int userDelete(int user_no); //회원탈퇴
    public void userModify(User user); //회원 수정





}
