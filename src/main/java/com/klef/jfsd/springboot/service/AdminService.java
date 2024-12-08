package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.entity.Admin;
import com.klef.jfsd.springboot.entity.Club;

public interface AdminService 
{
	public Admin checkAdminLogin(String username,String password);
	
	public String addClub(Club club);
	
	public List<Club> viewAllClubs();
}
