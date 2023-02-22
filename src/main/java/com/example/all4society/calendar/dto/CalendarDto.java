package com.example.all4society.calendar.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CalendarDto {
	private int id;
	private String title;
	private Date start;
	private Date end;
	private String user;
}
