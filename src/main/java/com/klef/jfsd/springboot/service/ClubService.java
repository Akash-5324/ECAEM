package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.Student;


public interface ClubService 
{
	public Club checkClubLogin(String name,String password);
	
	public String addEvent(Event event);
	
	public Club getClubById(int id);
	
	public List<Student> getStudentsByEventId(int eventId);
	
	public long getEventCount(int cid);
	
	public List<Event> findEventById(int cid);
}
