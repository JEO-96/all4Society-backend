package com.example.all4society.calendar.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CalendarDto {
	private int id;
	private String ctitle;
	private Date cstart;
	private Date cend;
}
