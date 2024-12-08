package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.Student;
import com.klef.jfsd.springboot.repository.ClubRepository;
import com.klef.jfsd.springboot.repository.EventRegistrationRepository;
import com.klef.jfsd.springboot.repository.EventRepository;

@Service
public class ClubServiceImpl implements ClubService
{
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
    private EventRegistrationRepository eventRegistrationRepository;

	@Override
	public Club checkClubLogin(String name, String password) {
		return clubRepository.checkClubLogin(name, password);
	}

	@Override
	public String addEvent(Event event) {
		eventRepository.save(event);
		return "Event added Successfully";
	}

	@Override
	public Club getClubById(int id) {
        return clubRepository.findById(id).orElse(null);
    }

	@Override
	public List<Student> getStudentsByEventId(int eventId) {
		return eventRegistrationRepository.findStudentsByEventId(eventId);
	}

	@Override
	public long getEventCount(int cid) {
		return eventRepository.countByClubId(cid);
	}

	@Override
	public List<Event> findEventById(int cid) {
		return eventRepository.findEventsByClubId(cid);
	}
}
