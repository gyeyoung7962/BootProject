package com.example.springprj.service;


import com.example.springprj.domain.User;

import java.util.List;

public interface UserService {



    public void insertUser(User user);
    public List<User> userList();
    public User login(String user_id, String user_pw);
    public int id_chk(String user_id);
}
