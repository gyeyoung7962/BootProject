package com.example.springprj.service;

import com.example.springprj.domain.Calendar;

import java.util.List;

public interface CalendarService {

    public void insertCalendar(Calendar calendar);

    public List<Calendar> calendarList();


}
