package com.example.all4society.calendar.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.all4society.calendar.dto.CalendarDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="scalendar")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Calendar {
	
	@Id
	@Column(name="c_num")
	private int id;
	
	@Column(name="c_title")
	private String title;
	
	@Column(name="c_start")
	private Date start;
	
	@Column(name="c_end")
	private Date end;
	
	public static Calendar createCalendar(CalendarDto calendarDto) {
		Calendar calendar = new Calendar();
		calendar.setId(calendarDto.getId());
		calendar.setTitle(calendarDto.getCtitle());
		calendar.setStart(calendarDto.getCstart());
		calendar.setEnd(calendarDto.getCend());
		
		return calendar;
	}

}
