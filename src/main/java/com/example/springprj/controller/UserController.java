package com.example.springprj.controller;


import com.example.springprj.domain.User;
import com.example.springprj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService userService;  //서비스 객체 의존성 주입

    @GetMapping("/test")
    public String testPage(Model model){
        System.out.println("===============testPage======================");

        List<User> list = userService.userList();

        model.addAttribute("list", list);

        return "user/user_list";
    }


}
