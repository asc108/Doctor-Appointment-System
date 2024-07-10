package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.model.Appointment;
import com.root.model.User;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
	
	
	Appointment findByUser(User user);
	 

}
