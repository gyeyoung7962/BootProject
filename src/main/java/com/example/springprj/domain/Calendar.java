package com.example.springprj.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Calendar {

    private int no;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private String color;
}
