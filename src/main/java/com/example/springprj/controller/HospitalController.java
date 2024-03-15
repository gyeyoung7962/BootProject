package com.example.springprj.controller;


import com.example.springprj.domain.Doctor;
import com.example.springprj.domain.HBoard;
import com.example.springprj.domain.HDList;
import com.example.springprj.domain.Hospital;
import com.example.springprj.service.DoctorService;
import com.example.springprj.service.HBoardService;
import com.example.springprj.service.HDListService;
import com.example.springprj.service.HospitalService;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.util.List;


@Controller
public class HospitalController {

    private static final Logger logger = LoggerFactory.getLogger(Hospital.class);


    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HBoardService hBoardService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private HDListService hdListService;

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
    public String getMapLocation(Model model) throws JsonProcessingException {

        List<Hospital> list = hospitalService.hospitalList();

        model.addAttribute("list", list);
        model.addAttribute("addressList", list.stream().map(e-> e.getHospital_address()).toList());
        model.addAttribute("nameList", list.stream().map(e-> e.getHospital_name()).toList());
        model.addAttribute("img", list.stream().map(e-> e.getFile_path()).toList());


        return "hospital/mapLocation";
    }

    @GetMapping("/hospital/apiTest")
    public String apiTest(){

        return "hospital/apiTest";
    }

    @GetMapping("/hospital/list")
    public String getList(Model model){

        List<Hospital> list = hospitalService.hospitalList();

        model.addAttribute("list", list);

        return "hospital/list";
    }

    @GetMapping("/hospital/info")
    public String getInfo(@RequestParam("hospital_no") int hospital_no, Model model, @RequestParam("hospital_code") String hospital_code){
        logger.info("========hospital_no ====" + hospital_no);

        Hospital hospital = hospitalService.hospitalInfo(hospital_no);
        List<HBoard> hbList =  hBoardService.listHBoard(hospital_code);

        model.addAttribute("hospital", hospital);
        model.addAttribute("hospital_code", hospital.getHospital_code());
        model.addAttribute("hospital_name", hospital.getHospital_name());
        model.addAttribute("hospital_no", hospital_no);
        model.addAttribute("hbList", hbList);

//        return "hospital/info?hospital_no="+hospital_no+"&hospital_code="+hospital_code;
        return "hospital/info";
    }

    @GetMapping("/hospital/enterDoctor")
    public String enterDoctor(@RequestParam("doctor_no")int doctor_no, @RequestParam("hospital_no") int hospital_no, Model model){

        logger.info("====doctor_no==={}",doctor_no);
        logger.info("====hospital_no===={}", hospital_no);

        Doctor doctor = doctorService.doctorInfo(doctor_no);

        logger.info("=====filePath==="+doctor.getFile_path());

        HDList hdList = new HDList();



        hdList.setDoctor_no(doctor_no);
        hdList.setHospital_no(hospital_no);
        hdList.setDoctor_name(doctor.getDoctor_name());
        hdList.setDoctor_birth(doctor.getDoctor_birth());
        hdList.setDoctor_phone(doctor.getDoctor_phone());
        hdList.setDoctor_career(doctor.getDoctor_career());
        hdList.setHospital_code(doctor.getHospital_code());
        hdList.setFile_Path(doctor.getFile_path());
        hdList.setDoctor_regDate(doctor.getDoctor_regDate());

        hdListService.insertHDList(hdList);

        return "hospital/list";
    }

    @GetMapping("/hospital/doctorList")
    public String getDoctorList(@RequestParam("hospital_no") int hospital_no, Model model){

        logger.info("===hospital_no=="+ hospital_no);

        model.addAttribute("list", hdListService.doctorList(hospital_no));

        return "hospital/doctorList";
    }







}
