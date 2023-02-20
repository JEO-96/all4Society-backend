package com.example.all4society.calendar.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.all4society.calendar.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
	
//	@Query(value="select new map (s.c_num as id, s.c_title as title, s.c_start as start, s.c_end as end) from scalendar s", nativeQuery=true)
//	List<Map<String, Object>> findAllCalendar();
}
