package com.example.all4society.calendar.controller;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.all4society.calendar.entity.Calendar;
import com.example.all4society.calendar.repository.CalendarRepository;
import com.example.all4society.calendar.service.CalendarService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/calendar")
@CrossOrigin("http://localhost:8082/")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private CalendarRepository calendarRepository;

	@GetMapping("/calendarview")
	public List<Calendar> findCalendar() {
		return calendarRepository.findAll();
	}
	
}
