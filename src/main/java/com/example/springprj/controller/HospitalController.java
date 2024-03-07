package com.example.springprj.controller;


import com.example.springprj.domain.Hospital;
import com.example.springprj.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


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
    public String postInsert(@ModelAttribute Hospital hospital, @RequestParam("postcode") String postcode, @RequestParam("address") String address, @RequestParam("detail") String detail, MultipartFile file) throws Exception{

        hospital.setHospital_address(postcode, address, detail);

        hospitalService.insertHospital(hospital, file);

        return "redirect:/";
    }


    @GetMapping("/hospital/mapLocation")
    public String getMapLocation(Model model){

        Hospital hospital = hospitalService.hospitalInfo();

        model.addAttribute("address", hospital.getHospital_address());
        model.addAttribute("name", hospital.getHospital_name());
        model.addAttribute("img", hospital.getFile_path());

        return "hospital/mapLocation";
    }

    @GetMapping("/hospital/apiTest")
    public String apiTest(){

        return "hospital/apiTest";
    }


}
