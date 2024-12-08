package com.klef.jfsd.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.entity.Event;
import com.klef.jfsd.springboot.entity.EventRegistration;
import com.klef.jfsd.springboot.entity.EventRegistrationId;
import com.klef.jfsd.springboot.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, EventRegistrationId> {
	
	@Query("SELECT e.student FROM EventRegistration e WHERE e.event.id = ?1")
	List<Student> findStudentsByEventId(int eventId);
	
	
	@Query("SELECT er.event.id FROM EventRegistration er WHERE er.student.id = :studentId")
    List<Integer> findBookedEventIdsByStudentId(@Param("studentId") String studentId);
	
	@Query("SELECT er.event FROM EventRegistration er WHERE er.student.id = :studentId")
	List<Event> findBookedEventsByStudentId(@Param("studentId") String studentId);
}
