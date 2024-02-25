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
}
