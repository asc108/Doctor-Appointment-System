package com.root.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.root.controller.dto.AppointmentRequest;
import com.root.model.Appointment;
import com.root.model.Doctor;
import com.root.model.User;
import com.root.repository.AppointmentRepo;
import com.root.repository.DoctorRepository;
import com.root.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	private final UserRepository userRepository;
	private final DoctorRepository doctorRepository;
	private final AppointmentRepo appointmentRepo;

	@Transactional
	public void makeAppointment(AppointmentRequest request) {
		User user = userRepository.findByUsername(request.user());
		Doctor doc = doctorRepository.findByFirstname(request.doctor());

		Appointment appointment = Appointment.builder().date(request.date()).info(request.info()).doctor(doc).user(user)
				.build();
		

		appointmentRepo.save(appointment);

	}

	public List<Appointment> getAppointments() {
		List<Appointment> lista = appointmentRepo.findAll();
		return lista;
	}

}
