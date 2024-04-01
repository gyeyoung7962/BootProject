package com.example.springprj.repository;


import com.example.springprj.domain.Calendar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
@Mapper
public interface CalendarMapper {

    public void insertCalendar(Calendar calendar);

    public List<Calendar> calendarList();



}
