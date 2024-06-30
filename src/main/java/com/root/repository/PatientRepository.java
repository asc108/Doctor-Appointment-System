package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.model.Patient;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	Patient findByFirstName(String firstName);

}
