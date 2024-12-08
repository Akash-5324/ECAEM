package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.EventRegistration;
import com.klef.jfsd.springboot.entity.Student;
import com.klef.jfsd.springboot.repository.ClubRepository;
import com.klef.jfsd.springboot.repository.EventRegistrationRepository;
import com.klef.jfsd.springboot.repository.EventRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventRegistrationRepository eventRegistrationRepository;
	
	@Override
	public String studentRegistration(Student student) 
	{
		studentRepository.save(student);
		return "Student Registered Successfully";
	}

	@Override
	public Student checkStudentLogin(String email, String password) {
		return studentRepository.checkStudentLogin(email, password);
	}

	@Override
	public Student checkIdUnique(String id) {
		return studentRepository.checkIdUnique(id);
	}

	@Override
	public List<Club> viewAllClubs() {
		return clubRepository.findAll();
	}

	@Override
	public List<Event> getEvents(int cid) {
		return eventRepository.findEventsByClubId(cid);
	}

	@Override
	public Event getEventsByid(int eid) {
		return eventRepository.findEventByid(eid);
	}

	@Override
	public String bookEvent(EventRegistration e) {
		eventRegistrationRepository.save(e);
		return "SUCCESS";
	}

	@Override
	public List<Integer> findBookedEventIdsByStudentId(String sid) {
		return eventRegistrationRepository.findBookedEventIdsByStudentId(sid);
	}

	@Override
	public List<Event> findBookedEventByStudentId(String sid) {
		return eventRegistrationRepository.findBookedEventsByStudentId(sid);
	}
	
	
	
	
}
