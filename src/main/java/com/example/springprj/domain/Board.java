package com.example.springprj.domain;


import lombok.Data;

import java.util.Date;

@Data
public class Board {

    private int board_no;
    private String board_writer;
    private String board_title;
    private String board_pw;
    private String board_content;
    private int board_viewCnt;
    private Date board_regDate;

}
