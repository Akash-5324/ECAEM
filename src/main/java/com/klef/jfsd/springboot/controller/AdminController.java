package com.klef.jfsd.springboot.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.entity.Admin;
import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.Student;
import com.klef.jfsd.springboot.repository.ClubRepository;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.ClubService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class AdminController 
{
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private ClubService clubService;

    @PostMapping("checkadminlogin")
    public ModelAndView loginAdmin(HttpServletRequest request) {
    	
    	ModelAndView mv = new ModelAndView();
		
		String auname = request.getParameter("auname");
		String apwd = request.getParameter("apwd");
		
        Admin admin = adminService.checkAdminLogin(auname,apwd);

        if (admin != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("admin", admin);
			
        	mv.setViewName("adminhome");
        } else {
            mv.addObject("message","Login Failed");
            mv.setViewName("ClubAdminLogin");
        }
        return mv;
    }
    
    @GetMapping("clubregistration")
    public ModelAndView clubRegistration(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("clubregistration");
		return mv;
    }

    @PostMapping("/addclub")
    public ModelAndView addClub(HttpServletRequest request)
    {
    	String name = request.getParameter("cname");
		String email = request.getParameter("cemail");
		String password = request.getParameter("cpwd");
		String description = request.getParameter("cdescription");
		String color = request.getParameter("colourText");
		
		Club club = new  Club();
		club.setName(name);
		club.setEmail(email);
		club.setPassword(password);
		club.setDescription(description);
		club.setColor(color);
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(description);
		System.out.println(color);
    	
    	ModelAndView mv = new ModelAndView();
    	Club existingClub = clubService.getClubById(club.getId());
        
        if (existingClub != null) 
        {
            mv.addObject("message", "Club Already Exist");
            mv.setViewName("studentlogin");
        }
        
        else 
        {
	        String message = adminService.addClub(club);
	        mv.addObject("message", message);
	        mv.setViewName("studentlogin");
        }
        return mv;
    }
    
    @GetMapping("clubs")
    public ModelAndView clubs(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
		
		 // Invalidate the session to log out the Club
       HttpSession session = request.getSession(false); // get the existing session if it exists
       if (session == null || session.getAttribute("admin") == null) {
           // Session is null or does not contain a "admin" attribute, meaning the user is logged out
           mv.setViewName("ClubAdminLogin");
           mv.addObject("message", "Please log in to access this page.");
           return mv;
       }
		
		mv.setViewName("clubs");
		List<Club> clubs = adminService.viewAllClubs();
		mv.addObject("clublist", clubs);
		return mv;
    }
    
    @GetMapping("adminhome")
    public ModelAndView adminHome(HttpServletRequest request) {
    	HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("admin") == null) {
            // Session is null or does not contain a "admin" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("ClubAdminLogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
    }
    
    @GetMapping("club")
    public ModelAndView club(HttpServletRequest request) {
    	HttpSession session = request.getSession(false); // Get existing session, but don't create a new one if it doesn't exist

        if (session == null || session.getAttribute("admin") == null) {
            // Session is null or does not contain a "admin" attribute, meaning the user is logged out
            ModelAndView mv = new ModelAndView();
            mv.setViewName("ClubAdminLogin");
            mv.addObject("message", "Please log in to access this page.");
            return mv;
        }
    	ModelAndView mv = new ModelAndView();
		mv.setViewName("club");
		return mv;
    }
    
    @GetMapping("adminlogout")
    public ModelAndView adminlogout(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView();
    	
    	 // Invalidate the session to log out the Admin
        HttpSession session = request.getSession(false); // get the existing session if it exists
        if (session != null) {
            session.invalidate(); // destroys the session
        }
    	
		mv.setViewName("home");
		return mv;
    }
}
