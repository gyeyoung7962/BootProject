package com.example.springprj.controller;


import com.example.springprj.domain.HBoard;
import com.example.springprj.service.HBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HBoardController {

    private final static Logger logger = LoggerFactory.getLogger(HBoardController.class);

    @Autowired
    private HBoardService hBoardService;

    @GetMapping("/hboard/insert")
    public String getWrite(@RequestParam("hospital_code") String hospital_code, @RequestParam("hospital_name") String hospital_name, @RequestParam("hospital_no") int hospital_no, Model model){

        model.addAttribute("hospital_code", hospital_code);
        model.addAttribute("hospital_name", hospital_name);
        model.addAttribute("hospital_no", hospital_no);

        return "hboard/insert";
    }

    @PostMapping("/hboard/insert")
    public String postWrite(@ModelAttribute HBoard hBoard, @RequestParam("hospital_no") int hospital_no){

        hBoardService.insertHBoard(hBoard);

        return "redirect:/hospital/info?hospital_code="+ hBoard.getHospital_code()+"&hospital_no="+hospital_no;
    }

    @GetMapping("/hboard/info")
    public String getInfo(@ModelAttribute HBoard hBoard, @RequestParam("hospital_no") int hospital_no, Model model){


        model.addAttribute("hBList",hBoardService.infoHBoard(hBoard.getHospital_code(), hospital_no));

        return "hboard/info";
    }

}
