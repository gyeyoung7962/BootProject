package com.example.springprj.controller;


import com.example.springprj.domain.User;
import com.example.springprj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "user/list";
    }

    @GetMapping("/user/insert")
    public String getInsert(){

        return "user/insert";
    }




    @PostMapping("/user/insert")
    public void insertUser(User user, @RequestParam("postcode")String postcode, @RequestParam("address")String address, @RequestParam("detail") String detail){

        user.setUser_addr(postcode, address, detail);
        userService.insertUser(user);

    }


}
