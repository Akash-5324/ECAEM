package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.entity.Admin;
import com.klef.jfsd.springboot.entity.Club;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.ClubRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ClubRepository clubRepository;

	@Override
	public Admin checkAdminLogin(String username, String password) {
		return adminRepository.checkAdminLogin(username, password);
	}

	@Override
	public String addClub(Club club) {
		clubRepository.save(club);
		return "Club added Successfully";
	}

	@Override
	public List<Club> viewAllClubs() {
		return clubRepository.findAll();
	}

}
