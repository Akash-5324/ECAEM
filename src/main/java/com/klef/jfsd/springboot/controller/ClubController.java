package com.klef.jfsd.springboot.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.Student;
import com.klef.jfsd.springboot.service.ClubService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class ClubController {
	@Autowired
	private ClubService clubService;

	@PostMapping("/insertevent")
	public ModelAndView registerStudent(HttpServletRequest request) {

		int cid = Integer.parseInt(request.getParameter("cid"));
		String ename = request.getParameter("ename");
		String evenue = request.getParameter("evenue");
		String edate = request.getParameter("edate");
		String etime = request.getParameter("etime");

		Club club = clubService.getClubById(cid);
		Event event = new Event();
        event.setClub(club);
        event.setName(ename);
        event.setDate(edate);
        event.setTime(etime);
        event.setVenue(evenue);
		
		ModelAndView mv = new ModelAndView();
		String message = clubService.addEvent(event);
		mv.addObject("message", message);
		mv.setViewName("clubhome");
		return mv;
	}

	@GetMapping("clublogin")
	public ModelAndView loginClub(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ClubAdminLogin");
		return mv;
	}

	@PostMapping("checkclublogin")
	public ModelAndView checkClubLogin(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		String cname = request.getParameter("cname");
		String cpwd = request.getParameter("cpwd");
		Club club = clubService.checkClubLogin(cname, cpwd);

		if (club != null) {
			HttpSession session = request.getSession(true);

			session.setAttribute("club", club);

			mv.setViewName("clubhome");
		} else {
			mv.setViewName("ClubAdminLogin");
			mv.addObject("message", "Login Failed");
		}
		return mv;
	}

	@GetMapping("clublogout")
	public ModelAndView clublogout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		// Invalidate the session to log out the Club
		HttpSession session = request.getSession(false); // get the existing session if it exists
		if (session != null) {
			session.invalidate(); // destroys the session
		}

		mv.setViewName("home");
		return mv;
	}

	@GetMapping("/students-by-event/{eventId}")
	public List<Student> getStudentsByEventId(@PathVariable int eventId) {
		return clubService.getStudentsByEventId(eventId);
	}

	@GetMapping("clubhome")
	public ModelAndView clubHome(HttpServletRequest request) {
		HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it
															// doesn't exist

		if (session == null || session.getAttribute("club") == null) {
			// Session is null or does not contain a "student" attribute, meaning the user
			// is logged out
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ClubAdminLogin");
			mv.addObject("message", "Please log in to access this page.");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clubhome");
		return mv;
	}

	@GetMapping("clubevents")
	public ModelAndView clubEvents(HttpServletRequest request) {
		HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it
															// doesn't exist

		if (session == null || session.getAttribute("club") == null) {
			// Session is null or does not contain a "student" attribute, meaning the user
			// is logged out
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ClubAdminLogin");
			mv.addObject("message", "Please log in to access this page.");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("clubevents");
		return mv;
	}

	@GetMapping("addevent")
	public ModelAndView addevent(HttpServletRequest request) {
		HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it
															// doesn't exist

		if (session == null || session.getAttribute("club") == null) {
			// Session is null or does not contain a "student" attribute, meaning the user
			// is logged out
			ModelAndView mv = new ModelAndView();
			mv.setViewName("ClubAdminLogin");
			mv.addObject("message", "Please log in to access this page.");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addevent");
		return mv;
	}
	
	@GetMapping("clubprofile")
	public ModelAndView clubprofile(HttpServletRequest request) 
	{
    	HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("club") == null) {
            // Session is null or does not contain a "club" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("ClubAdminLogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }
        
        
        Club c = (Club)session.getAttribute("club");
        long count = clubService.getEventCount(c.getId());
        
        
		ModelAndView mv = new ModelAndView();
		mv.addObject("count", count);
		mv.setViewName("clubprofile");
		return mv;
	}
	
	@GetMapping("cmyevents")
    public ModelAndView myevents(HttpServletRequest request) {
    	 HttpSession session = request.getSession(false);

         if (session == null || session.getAttribute("club") == null) {
             ModelAndView mv = new ModelAndView("ClubAdminLogin");
             mv.addObject("message", "Please log in to access this page.");
             return mv;
         }
         
         Club club = (Club) session.getAttribute("club");
         
         List<Event> events = clubService.findEventById(club.getId());
         
         ModelAndView mv = new ModelAndView("ceventlist");
         
         mv.addObject("events", events);
         
         return mv;    
    }
	
	@PostMapping("students")
	public ModelAndView students(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);

	    if (session == null || session.getAttribute("club") == null) {
	        ModelAndView mv = new ModelAndView("ClubAdminLogin");
	        mv.addObject("message", "Please log in to access this page.");
	        return mv;
	    }
	    Club club = (Club) session.getAttribute("club");
	    
	    int eid = Integer.parseInt(request.getParameter("eventId"));
	    
	    List<Student> students = clubService.getStudentsByEventId(eid);
	    
	    ModelAndView mv = new ModelAndView("students");
	    mv.addObject("students", students);
	    
	    return mv;
	}

	
}
