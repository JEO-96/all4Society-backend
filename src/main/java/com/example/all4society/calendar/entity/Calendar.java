package com.example.all4society.calendar.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_num", columnDefinition = "serial")
	private int id;
	
	@Column(name="c_title")
	private String title;
	
	@Column(name="c_start")
	private Date start;
	
	@Column(name="c_end")
	private Date end;
	
	@Column(name="c_user")
	private String user;
	
	public static Calendar createCalendar(CalendarDto calendarDto, String userId) {
		Calendar calendar = new Calendar();
		calendar.setId(calendarDto.getId());
		calendar.setTitle(calendarDto.getTitle());
		calendar.setStart(calendarDto.getStart());
		calendar.setEnd(calendarDto.getEnd());
//		calendar.setUser(calendarDto.getUser());
		calendar.setUser(userId);
		
		return calendar;
	}

}
