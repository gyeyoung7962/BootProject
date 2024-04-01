package com.example.springprj.controller;


import com.example.springprj.domain.Calendar;
import com.example.springprj.service.CalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class CalendarController {

    private final Logger logger = LoggerFactory.getLogger(CalendarController.class);

    @Autowired
    private CalendarService calendarService;


    @PostMapping("/calendar/insert")
    @ResponseBody
    public String addCalendar(@RequestBody List<Map<String, Object>> param) throws Exception {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);


        for (int i = 0; i < param.size(); i++) {
            logger.info("=====param==={}", param.get(i));
        }

        for (int i = 0; i < param.size(); i++) {

            Calendar calendar = new Calendar();

            String title = (String) param.get(i).get("title");
            String start = (String) param.get(i).get("start");
            String end = (String) param.get(i).get("end");

            LocalDateTime startDate = LocalDateTime.parse(start, dateTimeFormatter);
            LocalDateTime endDate = LocalDateTime.parse(end, dateTimeFormatter);

            calendar.setTitle(title);
            calendar.setStart(startDate);
            calendar.setEnd(endDate);

            calendarService.insertCalendar(calendar);
        }
        return "redirect:/calendar/list";
    }

    @GetMapping(value = "/calendar/list")
    @ResponseBody
    public List<Map<String, Object>> getList() {

        List<Map<String, Object>> eventList = new ArrayList<>();

        for (Calendar calendar : calendarService.calendarList()) {
            Map<String, Object> event = new HashMap<>();

            event.put("title", calendar.getTitle());
            event.put("start", calendar.getStart());
            event.put("end", calendar.getEnd());
            System.out.println("event 값 :" + "제목:" + event.get("title") + "\t" + "시작일:" + event.get("start") + "\t" + "종료일:" + event.get("end"));

            eventList.add(event);
        }
        return eventList;
    }


}
