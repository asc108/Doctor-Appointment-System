package com.root.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "appointment")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private int id;
	
	private LocalDateTime date; 
	
	private String info;
	
	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	

}
