package com.root.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "medical_record")
@Builder
@AllArgsConstructor
@Data	
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicalRecord_id")
	private int id;
	@Column(columnDefinition = "LONGTEXT")
	private String diagnosis;
	@Column(columnDefinition = "LONGTEXT")
	private String treatment;

	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

}
