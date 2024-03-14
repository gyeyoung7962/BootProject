package com.example.springprj.controller;


import com.example.springprj.domain.Board;
import com.example.springprj.domain.Criteria;
import com.example.springprj.domain.PageMaker;
import com.example.springprj.service.BoardService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private final static Logger logger = LoggerFactory.getLogger(BoardController.class);


    @Autowired
    private BoardService boardService;

    @GetMapping("/board/insert")
    public String getInsert(Model model, HttpServletRequest req) {




        return "board/insert";
    }

    @PostMapping("/board/insert")
    public String postInsert(@ModelAttribute Board board) {

        boardService.insertBoard(board);



        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String getList(Model model){

        List<Board> board = boardService.listBoard();

        model.addAttribute("list", board);

        return "board/list";
    }

    @GetMapping("/board/read")
    public String getRead(@RequestParam("board_no")int board_no, Model model, HttpServletRequest req, HttpServletResponse resp){


        Cookie[] cookies = req.getCookies();

        if(cookies != null){
            for(Cookie cookie : cookies){

                if (!cookie.getValue().contains(req.getParameter("board_no"))) {

                    cookie.setValue(cookie.getValue()+ "_" + req.getParameter("board_no"));
                    cookie.setMaxAge(60 * 60 * 2);
                    resp.addCookie(cookie);
                    boardService.updateViewCnt(board_no);
                }
            }
        }else{
            Cookie newCookie = new Cookie("newCookie", req.getParameter("board_no"));
            newCookie.setMaxAge(60*60*2);
            resp.addCookie(newCookie);
            boardService.updateViewCnt(board_no);
         }

        Board board = boardService.readBoard(board_no);
        model.addAttribute("board", board);

        return "board/info";
    }

    /*
    @GetMapping("/board/listCriteria")
    public String listCriteria(Criteria cri, Model model) throws Exception{

        logger.info("cri.getPage"+ cri.getPage());
        logger.info("cri.getPageStart"+ cri.getPageStart());
        logger.info("cri.getPerPageNum"+ cri.getPerPageNum());

        model.addAttribute("list", boardService.listCriteria(cri));

        return "board/listCriteria";
    }
     */

    @GetMapping("/board/listPaging")
    public String listPaging(Model model, Criteria cri) throws Exception{

        logger.info("get page"+cri.getPage());
        logger.info("get pageStart"+cri.getPageStart());
        logger.info("get perPageNum"+cri.getPerPageNum());

        PageMaker pageMaker = new PageMaker();

        pageMaker.setCriteria(cri);

        pageMaker.setTotalCount(boardService.boardCount());

        logger.info(pageMaker.toString());

        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("list", boardService.listCriteria(cri));

        return "board/listCriteria";
    }



}
