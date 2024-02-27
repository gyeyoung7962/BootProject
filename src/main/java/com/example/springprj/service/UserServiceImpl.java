package com.example.springprj.service;

import com.example.springprj.domain.User;
import com.example.springprj.repository.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {



    private final UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void insertUser(User user) {

        userMapper.insertUser(user);
    }

    @Override
    public List<User> userList() {

        return userMapper.userList();
    }

    @Override
    public User login(String user_id, String user_pw) {


        return userMapper.login(user_id, user_pw);
    }

    @Override
    public int id_chk(String user_id) {

        int id_chk_result = userMapper.id_chk(user_id);

        return id_chk_result;
    }

    @Override
    public User userInfo(int user_no) {

        return userMapper.userInfo(user_no);
    }

    @Override
    public int userDelete(int user_no) {

        return userMapper.userDelete(user_no);

    }

    @Override
    public void userModify(User user) {

        userMapper.userModify(user);
    }
}
