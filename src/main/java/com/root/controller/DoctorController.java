package com.root.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.controller.dto.DoctorRequest;
import com.root.controller.dto.PatientMedicalRecordDTO;
import com.root.controller.dto.PatientRecord;
import com.root.controller.dto.PatientRequestDTO;
import com.root.model.Doctor;
import com.root.model.Patient;
import com.root.service.DocService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/doc")
@RequiredArgsConstructor
public class DoctorController {

	private final DocService docService;

	@PostMapping("/addDoctor")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<String> addDoctor(@RequestBody DoctorRequest request) {
		try {
			docService.addDoctor(request);
			return new ResponseEntity<>("Succsessfull registration", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/addRecord")
	@PreAuthorize("hasAnyRole('ROLE_DOCTOR')")
	public ResponseEntity<String> newPatientRecord(@RequestBody PatientMedicalRecordDTO request) {
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

	@PostMapping("/addPatient")
	@PreAuthorize("hasAnyRole('ROLE_DOCTOR')")
	public ResponseEntity<String> addPatient(@RequestBody PatientRequestDTO request) {
		try {
			docService.addPatient(request);
			return new ResponseEntity<>("Succsessfull", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/allPatients")
	@PreAuthorize("hasAnyRole('ROLE_DOCTOR')")
	public List<Patient> getAllPatients() {
		return docService.getAllPatients();
	}
	
	
	
	
	



	
	
	

}
