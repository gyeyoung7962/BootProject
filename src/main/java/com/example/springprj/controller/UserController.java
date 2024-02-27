package com.example.springprj.controller;


import com.example.springprj.domain.User;
import com.example.springprj.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;  //서비스 객체 의존성 주입

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String getIndex(){

        return "/index";
    }

    //회원목록
    @GetMapping("/user/list")
    public String testPage(Model model){
        System.out.println("===============testPage======================");

        List<User> list = userService.userList();

        model.addAttribute("list", list);

        return "user/list";
    }

    //회원구분
    @GetMapping("/user/choose")
    public String getInsertChoose(){

        return "user/insertChoose";
    }

    //회원가입폼
    @GetMapping("/user/insert")
    public String getInsert(){

        return "user/insert";
    }

    //회원가입 전송
    @PostMapping("/user/insert")
    public void insertUser(User user, @RequestParam("postcode")String postcode, @RequestParam("address")String address, @RequestParam("detail") String detail){

        user.setUser_addr(postcode, address, detail);
        userService.insertUser(user);

    }

    //아이디 중복체크
    //ajax 데이터 받을때 responsebody로 데이터를 받아야함
    @GetMapping("/user/id_Chk")
    public @ResponseBody int  id_Chk(@RequestParam("user_id") String id){

        int id_chk_result = userService.id_chk(id);
        return id_chk_result;
    }

    //로그인화면
    @GetMapping("/user/login")
    public String getLogin() {
        return "user/login";
    }

    //로그인
    @PostMapping("/user/login")
    public String login(@RequestParam("user_id") String user_id, @RequestParam("user_pw") String user_pw, HttpServletRequest request, Model model){

        User user = userService.login(user_id, user_pw);
        if(user != null){
            HttpSession session = request.getSession(true);

            session.setAttribute("user_name",user.getUser_name());
            session.setAttribute("user_no", user.getUser_no());
            session.setAttribute("userVO", user);
            session.setMaxInactiveInterval(60*30);

            model.addAttribute("session", session);
        }
        return "redirect:/";
    }

    //로그아웃
    @GetMapping("/user/logout")
    public String logout(HttpSession session){

        session.invalidate();

        return "redirect:/";
    }

    //회원정보
    @GetMapping("/user/info")
    public String getUserInfo(@RequestParam("user_no") int user_no, Model model){

        User user = userService.userInfo(user_no);
        model.addAttribute("user", user);
        model.addAttribute("user_no", user_no);

        return "user/info";
    }

    @PostMapping("/user/delete")
    public String postUserDelete(int user_no, Model model){

        int no = userService.userDelete(user_no);


        if(no == 0){
            model.addAttribute("msg", "삭제완료");
        }

        return "redirect:/";
    }

    @PostMapping("/user/modify")
    public String postUserModify(@RequestParam("user_no")int user_no, User user, Model model, RedirectAttributes rttr){

            String userNo = Integer.toString(user.getUser_no());
//            logger.info("============="+user_no);
            logger.info("============user============{}",userNo);

            model.addAttribute("user_no", user_no);
            userService.userModify(user);



            return "redirect:/user/info?user_no=" + userNo;
    }

    @GetMapping("/user/modify")
    public String getUserModify(@RequestParam("user_no") int user_no, Model model){

        logger.info("======"+user_no);


        model.addAttribute("user_no", user_no);
        model.addAttribute("user", userService.userInfo(user_no));

        return "user/modify";



    }

}
