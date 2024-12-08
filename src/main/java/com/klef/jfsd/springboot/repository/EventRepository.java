package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klef.jfsd.springboot.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>
{
	long countByClubId(int clubId);
	@Query("SELECT e FROM Event e WHERE e.club.id = :clubId")
	List<Event> findEventsByClubId(@Param("clubId") int clubId);
	
	@Query("select e from Event e where e.id =?1")
	Event findEventByid(int eid);
	
}
