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








}
