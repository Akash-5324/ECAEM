package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.EventRegistration;
import com.klef.jfsd.springboot.entity.Student;

public interface StudentService 
{
	public String studentRegistration(Student s);
	public Student checkStudentLogin(String email,String password);
	public Student checkIdUnique(String id);
	public List<Club> viewAllClubs();
	public List<Event> getEvents(int cid);
	public Event getEventsByid(int eid);
	public String bookEvent(EventRegistration e);
	List<Integer> findBookedEventIdsByStudentId(String sid);
	List<Event> findBookedEventByStudentId(String sid);
}
