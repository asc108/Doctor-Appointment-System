package com.root.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.root.controller.dto.DoctorRequest;
import com.root.controller.dto.PatientRecord;
import com.root.model.Appointment;
import com.root.model.Doctor;
import com.root.service.DocService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/doc")
@RequiredArgsConstructor
public class DoctorController {

	private final DocService docService;

	@PostMapping("/addDoctor")
	public ResponseEntity<String> addDoctor(@RequestBody DoctorRequest request) {
		try {
			docService.addDoctor(request);
			return new ResponseEntity<>("Succsessfull registration", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/addRecord")
	public ResponseEntity<String> newPatientRecord(@RequestBody PatientRecord request) {
		try {
			docService.newPatientRecord(request);
			return new ResponseEntity<>("Succsessfull registration", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}

	}
	
	

	@GetMapping("/allDoctors")
	public List<Doctor> getAllDoctors() {
		return docService.getAllDoctors();
	}
	
	
	



	
	
	

}
