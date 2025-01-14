package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer>
{
	@Query("select c from Club c where c.name=?1 and c.password=?2")
	public Club checkClubLogin(String name,String password);
}
