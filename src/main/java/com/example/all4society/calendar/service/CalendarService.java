package com.example.all4society.calendar.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.all4society.calendar.entity.Calendar;
import com.example.all4society.calendar.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarService {
	
	private final CalendarRepository calendarRepository;
	
	public Calendar saveCalendar(Calendar calendar) {
		return calendarRepository.save(calendar);
	}
//	

}
