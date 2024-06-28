package com.root.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.root.controller.dto.DoctorRequest;
import com.root.controller.dto.PatientRecord;
import com.root.model.Appointment;
import com.root.model.Doctor;
import com.root.model.User;
import com.root.repository.AppointmentRepo;
import com.root.repository.DoctorRepository;
import com.root.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocService {
	private final DoctorRepository doctorRepository;
	private final UserRepository userRepository;
	private final AppointmentRepo appointmentRepo;

	public void addDoctor(DoctorRequest request) {

		Doctor doctor = Doctor.builder().speciality(request.speciallity()).contactInfo(request.contactInfo())
				.firstname(request.firstname()).lastname(request.lastname()).build();

		doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> lista = doctorRepository.findAll();
		return lista;
	}

	public void newPatientRecord(PatientRecord request) {
		// TODO Auto-generated method stub

	}

}
