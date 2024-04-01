package com.example.springprj.service;


import com.example.springprj.domain.Calendar;
import com.example.springprj.repository.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {



    @Autowired
    private CalendarMapper calendarMapper;

    @Override
    public void insertCalendar(Calendar calendar) {


        calendarMapper.insertCalendar(calendar);
    }

    @Override
    public List<Calendar> calendarList() {

        return calendarMapper.calendarList();
    }
}
