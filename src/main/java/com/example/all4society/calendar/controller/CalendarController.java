package com.example.all4society.calendar.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.all4society.calendar.dto.CalendarDto;
import com.example.all4society.calendar.entity.Calendar;
import com.example.all4society.calendar.repository.CalendarRepository;
import com.example.all4society.calendar.service.CalendarService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8082/")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@Autowired
	private CalendarRepository calendarRepository;

	@GetMapping("/calendarview")
	public List<Calendar> findCalendar(HttpSession session) {
		String userId = (String) session.getAttribute("sessionId");
//		System.out.println("session : " + userId);
		System.out.println(calendarRepository.findAllByCUser(userId));
		return calendarRepository.findAllByCUser(userId);
	}
	
	@PostMapping("/calendarInsert")
	public Map<String, Object> calendarInsert(@RequestBody CalendarDto calendarDto, HttpSession session) {
		String userId = (String)session.getAttribute("sessionId");
		Map<String, Object> map = new HashMap<>();
		map.put("calendarDto", calendarDto);
		try {
			Calendar calendar = Calendar.createCalendar(calendarDto, userId);
			calendarService.saveCalendar(calendar);
		} catch (Exception e) {
			map.put("status", -1);
			map.put("result", e.getMessage());
		}
		return map;
		
	}
	
	@PostMapping("/calendarDelete")
	public void calendarDelete(@RequestBody CalendarDto calendarDto) {
		Map<String, Object> map = new HashMap<>();
		map.put("calendarDto", calendarDto);
		System.out.println("======================삭제 찍혀?:" + calendarDto);
		calendarRepository.deleteMethod(calendarDto.getTitle(), calendarDto.getStart());
		
	}
	
}
