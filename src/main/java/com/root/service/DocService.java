package com.root.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.root.controller.dto.DoctorRequest;
import com.root.controller.dto.PatientMedicalRecordDTO;
import com.root.controller.dto.PatientRequestDTO;
import com.root.model.Doctor;
import com.root.model.MedicalRecord;
import com.root.model.Patient;
import com.root.repository.AppointmentRepo;
import com.root.repository.DoctorRepository;
import com.root.repository.MedicalRecordRepository;
import com.root.repository.PatientRepository;
import com.root.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocService {
	private final DoctorRepository doctorRepository;
	private final UserRepository userRepository;
	private final AppointmentRepo appointmentRepo;
	private final PatientRepository patientRepository;
	private final MedicalRecordRepository medicalRecordRepository;

	public void addDoctor(DoctorRequest request) {

		Doctor doctor = Doctor.builder().speciality(request.speciallity()).contactInfo(request.contactInfo())
				.firstname(request.firstname()).lastname(request.lastname()).build();

		doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctors() {
		List<Doctor> lista = doctorRepository.findAll();
		return lista;
	}

	public void newPatientRecord(PatientMedicalRecordDTO request) {
		
		Patient patient = patientRepository.findByFirstName(request.patientname());
		
		Doctor doctor = doctorRepository.findByFirstname(request.doctorname());
		
		MedicalRecord medicalRecord = MedicalRecord.builder().diagnosis(request.diagnosis()).treatment(request.treatment()).patient(patient).build();
		try {
			medicalRecordRepository.save(medicalRecord);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		

	}

	public void addPatient(PatientRequestDTO request) {
		Patient patient = Patient.builder().firstName(request.firstname()).lastName(request.lastname())
				.dateOfBirth(request.date()).contactInfo(request.contactInfo()).additionalInfo(request.additionalInfo())
				.build();
		patientRepository.save(patient);
	}

	public List<Patient> getAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		return patients;
	}

}
