package com.example.springprj.service;


import com.example.springprj.domain.User;

import java.util.List;

public interface UserService {



    public void insertUser(User user);
    public List<User> userList();
}
