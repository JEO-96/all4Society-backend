package com.example.all4society.calendar.repository;

import java.sql.Date;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.all4society.calendar.entity.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
	
//	@Query(value="select new map (s.c_num as id, s.c_title as title, s.c_start as start, s.c_end as end) from scalendar s", nativeQuery=true)
//	List<Map<String, Object>> findAllCalendar();
	
	@Query(value="select * from scalendar where c_user = :userId", nativeQuery = true)
	List<Calendar> findAllByCUser(String userId);
	
	@Query(value="delete from scalendar where c_title = :ctitle and c_start = :cstart", nativeQuery = true)
	void deleteMethod(String ctitle, Date cstart);
}
