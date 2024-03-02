package com.example.springprj.controller;


import com.example.springprj.domain.Doctor;
import com.example.springprj.service.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    private final Logger logger = LoggerFactory.getLogger(DoctorController.class);


    @GetMapping("/doctor/insert")
    public String getInsert(){

        return "doctor/insert";
    }

    @PostMapping("/doctor/insert")
    public String postInsert(Doctor doctor){


        doctorService.insertDoctor(doctor);

        return "redirect:/";

    }


}
