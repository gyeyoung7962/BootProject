package com.example.springprj.domain;


import lombok.Data;

import java.util.Date;

@Data
public class HBoard {

    private int h_board_no;
    private String h_board_writer;
    private String h_board_title;
    private String h_board_pw;
    private String h_board_content;
    private int h_board_viewCnt;
    private Date h_board_regDate;
    private int hospital_no;
    private String hospital_code;
}
