package com.example.springprj.controller;


import com.example.springprj.domain.Hospital;
import com.example.springprj.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HospitalController {

    private static final Logger logger = LoggerFactory.getLogger(Hospital.class);


    @Autowired
    private HospitalService hospitalService;





    @GetMapping("/hospital/insert")
    public String getInsert(){

        return "hospital/insert";
    }

    @PostMapping("/hospital/insert")
    public String postInsert(@ModelAttribute Hospital hospital, @RequestParam("postcode") String postcode, @RequestParam("address") String address, @RequestParam("detail") String detail) throws Exception{

        hospital.setHospital_address(postcode, address, detail);

        hospitalService.insertHospital(hospital);

        return "redirect:/";
    }



    @GetMapping("/hospital/mapLocation")
    public String getMapLocation(){

        return "hospital/mapLocation";
    }


}
