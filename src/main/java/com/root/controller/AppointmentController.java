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

import com.root.controller.dto.AppointmentRequest;
import com.root.controller.dto.CancelAppointmentRequest;
import com.root.model.Appointment;
import com.root.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
	private final AppointmentService appointmentService;

	@PostMapping("/makeAppointment")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_DOCTOR')")
	public ResponseEntity<String> makeAppointment(@RequestBody AppointmentRequest request) {

		try {
			appointmentService.makeAppointment(request);
			return new ResponseEntity<String>("Succsessfull", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);

		}

	}
	
	@GetMapping("/getAppointments")
	@PreAuthorize("hasAnyRole('ROLE_DOCTOR')")
	public List<Appointment> getAppointments() {
		return appointmentService.getAppointments();
		
	}
	
	@PostMapping("/cancelAppointment")
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	public ResponseEntity<String> cancelAppointement(@RequestBody CancelAppointmentRequest request) {

		try {
			appointmentService.cancelAppointement(request);
			return new ResponseEntity<String>("Succsessfull", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);

		}

	}

}
