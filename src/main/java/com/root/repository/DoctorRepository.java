package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.root.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Doctor findByFirstname(String firstname);
 

}
