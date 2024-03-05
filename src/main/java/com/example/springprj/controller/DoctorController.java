package com.example.springprj.controller;


import com.example.springprj.domain.Doctor;
import com.example.springprj.domain.User;
import com.example.springprj.service.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@Controller
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    private final Logger logger = LoggerFactory.getLogger(DoctorController.class);


    @GetMapping("/doctor/insert")
    public String getInsert() {

        return "doctor/insert";
    }

    @PostMapping("/doctor/insert")
    public String testDoctorInsert(Doctor doctor, MultipartFile file)throws Exception{

        doctorService.insertDoctor(doctor, file);

        return "redirect:/";
    }



    @GetMapping("/doctor/login")
    public String getLogin() {

        return "doctor/login";
    }

    @PostMapping("/doctor/login")
    public String postLogin(@RequestParam("doctor_code") String doctor_code, @RequestParam("doctor_pw") String doctor_pw, HttpServletRequest req, Model model) {

        Doctor doctor = doctorService.login(doctor_code, doctor_pw);
        if(doctor != null){
            HttpSession session = req.getSession(true);

            session.setAttribute("doctor_name",doctor.getDoctor_name());
            session.setAttribute("doctor_no", doctor.getDoctor_no());
            session.setAttribute("doctorVO", doctor);
            session.setMaxInactiveInterval(60*30);

            model.addAttribute("session", session);
        }

        return "redirect:/";
    }

    @GetMapping("/doctor/logout")
    public String postLogout(HttpServletRequest req) {

        HttpSession session =  req.getSession();
        session.invalidate();

        return "redirect:/";
    }
    @GetMapping("/doctor/info")
    public String getInfo(@RequestParam("doctor_no")int doctor_no, Model model){

        Doctor doctor = doctorService.doctorInfo(doctor_no);

        model.addAttribute("doctor_no", doctor_no);
        model.addAttribute("doctor", doctor);


        return "doctor/info";
    }

    @GetMapping("/doctor/modify")
    public String getModify(@RequestParam("doctor_no") int doctor_no, Model model, MultipartFile file ){

        Doctor doctor = doctorService.doctorInfo(doctor_no);

        model.addAttribute("file", file);
        model.addAttribute("doctor", doctor);
        model.addAttribute("doctor_no", doctor_no);

        return "doctor/modify";
    }

    @PostMapping("/doctor/modify")
    public String postModify(Doctor doctor, @RequestParam("doctor_no") int doctor_no, MultipartFile file) throws Exception{

        doctor.setFile_name(doctorService.doctorInfo(doctor_no).getFile_name());
        doctor.setFile_path(doctorService.doctorInfo(doctor_no).getFile_path());


        logger.info("==========file============={}",file.isEmpty());
        if(!file.isEmpty()){
            doctorService.doctorModify(doctor, file);
        }else {
            String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/upload"; //프로젝트 폴더경로
            File f = new File(projectPath, doctor.getFile_name());  //프로젝트경로와 파일이름으로 경로생성

            doctor.setFile_name(doctor.getFile_name()); //디비에 값저장
            doctor.setFile_path("/upload/"+doctor.getFile_name());

            doctorService.doctorModify(doctor);


        }

        return "redirect:/doctor/info?doctor_no="+doctor_no;

    }

    @PostMapping("/doctor/delete")
    public String doctorDelete(@RequestParam("doctor_no") int doctor_no){

         Doctor doctor = doctorService.doctorInfo(doctor_no);

        doctorService.doctorDelete(doctor_no, doctor);

        return "redirect:/";
    }




}
