package com.klef.jfsd.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.EventRegistration;
import com.klef.jfsd.springboot.entity.Student;
import com.klef.jfsd.springboot.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class StudentController 
{
    @Autowired
    private StudentService studentService;
    
    
    @GetMapping("/")
    public ModelAndView Home() {
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
    
    
    @PostMapping("insertstudent")
    public ModelAndView registerStudent(HttpServletRequest request) {
        
    	String id = request.getParameter("sid");
    	String name = request.getParameter("sname");
		String gender = request.getParameter("sgender");
		String dob = request.getParameter("sdob");
		String email = request.getParameter("semail");
		String password = request.getParameter("spwd");
		String department = request.getParameter("sdepartment");
		String contact = request.getParameter("scontact");
		
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setGender(gender);
		student.setDateofbirth(dob);
		student.setDepartment(department);
		student.setContactno(contact);
    	
    	ModelAndView mv = new ModelAndView();
    	Student existingStudent = studentService.checkIdUnique(student.getId());
        
        if (existingStudent != null) 
        {
            mv.addObject("message", "User Already Exist");
            mv.setViewName("studentlogin");
        }
        
        else 
        {
	        String message = studentService.studentRegistration(student);
	        mv.addObject("message", message);
	        mv.setViewName("studentlogin");
        }
        return mv;
    }
    
    @GetMapping("studentlogin")
	public ModelAndView studentlogin() 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentlogin");
		return mv;
	}
    
    @PostMapping("checkstudentlogin")
    public ModelAndView checkStudentLogin(HttpServletRequest request) {
    	
    	ModelAndView mv = new ModelAndView();
		
		String semail = request.getParameter("semail");
		String spwd = request.getParameter("spwd");
		
        Student student = studentService.checkStudentLogin(semail,spwd);
        
        if (student != null) {
            HttpSession session = request.getSession(true);
            
            session.setAttribute("student", student);
			
			mv.setViewName("studenthome");
        } 
        else 
        {
            mv.setViewName("studentlogin");
			mv.addObject("message", "Login Failed");
        }
        return mv;
    }
    
    @GetMapping("studenthome")
    public ModelAndView studentHome(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("student") == null) {
            // Session is null or does not contain a "student" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("studentlogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }

        // If the session exists and contains a "student" attribute, allow access to the page
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studenthome"); // or the view you want to load if logged in
        return mv;
    }
    
    @GetMapping("studentevents")
    public ModelAndView studenevents(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("student") == null) {
            // Session is null or does not contain a "student" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("studentlogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }

        // If the session exists and contains a "student" attribute, allow access to the page
        ModelAndView mv = new ModelAndView();
        mv.setViewName("studentevents"); // or the view you want to load if logged in
        return mv;
    }
    
    @GetMapping("viewclubs")
    public ModelAndView viewClubs(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("student") == null) {
            // Session is null or does not contain a "student" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("studentlogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }

        // If the session exists and contains a "student" attribute, allow access to the page
        ModelAndView mv = new ModelAndView();
        mv.setViewName("viewclubs");
		List<Club> clubs = studentService.viewAllClubs();
		mv.addObject("clublist", clubs);
		return mv;
    }

    @GetMapping("studentlogout")
    public ModelAndView studentlogout(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        // Invalidate the session to log out the student
        HttpSession session = request.getSession(false); // get the existing session if it exists
        if (session != null) {
            session.invalidate(); // destroys the session
        }
        
        mv.setViewName("home");
        return mv;
    }
    
    @GetMapping("studentprofile")
	public ModelAndView studentprofile(HttpServletRequest request) 
	{
    	HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("student") == null) {
            // Session is null or does not contain a "student" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("studentlogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }
        
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentprofile");
		return mv;
	}
    
    @GetMapping("eventregistration")
    public ModelAndView eventregistration(HttpServletRequest request) {
    	HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("student") == null) {
            // Session is null or does not contain a "student" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("studentlogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }
        
     // If the session exists and contains a "student" attribute, allow access to the page
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eventclubregistration");
		List<Club> clubs = studentService.viewAllClubs();
		mv.addObject("clublist", clubs);
		return mv;
    }
    
    @PostMapping("events")
    public ModelAndView events(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("student") == null) {
            ModelAndView mv = new ModelAndView("studentlogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }

        // Retrieve 'cid' from the request parameter
        int cid = Integer.parseInt(request.getParameter("clubId"));
        Student student = (Student) session.getAttribute("student");

        // Process and retrieve events
        ModelAndView mv = new ModelAndView("events");
        List<Event> events = studentService.getEvents(cid);

        // Get list of events the student has already booked
        List<Integer> bookedEventIds = studentService.findBookedEventIdsByStudentId(student.getId());

        mv.addObject("eventlist", events);
        mv.addObject("bookedEventIds", bookedEventIds);
        return mv;
    }


    @PostMapping("bookevent")
    public ResponseEntity<Map<String, Object>> bookEvent(@RequestParam("eventId") int eventId, HttpSession session) {
        // Validate session
        if (session == null || session.getAttribute("student") == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Please log in to access this page.");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

        Student student = (Student) session.getAttribute("student");
        Event event = studentService.getEventsByid(eventId);

        // Create EventRegistration object
        EventRegistration eventRegistration = new EventRegistration(event, student);
        String result = studentService.bookEvent(eventRegistration);

        Map<String, Object> response = new HashMap<>();
        boolean success = false;
        String message;

        // Handle booking result
        if ("SUCCESS".equals(result)) {
            success = true;
            message = "Event booked successfully!";
        } else {
            message = "Failed to book the event. Please try again.";
        }

        // Prepare data for the frontend
        response.put("success", success);
        response.put("message", message);
        response.put("eventId", eventId);

        return ResponseEntity.ok(response); // Return JSON response
    }


    @GetMapping("myevents")
    public ModelAndView myevents(HttpServletRequest request) {
    	 HttpSession session = request.getSession(false);

         if (session == null || session.getAttribute("student") == null) {
             ModelAndView mv = new ModelAndView("studentlogin");
             mv.addObject("message", "Please log in to access this page.");
             return mv;
         }
         
         Student student = (Student) session.getAttribute("student");
         
         List<Event> events = studentService.findBookedEventByStudentId(student.getId());
         
         ModelAndView mv = new ModelAndView("seventlist");
         
         mv.addObject("events", events);
         
         return mv;
         
    }
    
    
    
    
}
