package com.root.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int id;
	
	private String first_name;
	private String last_name;
	private String speciality;
	private String contactInfo;
	
	@OneToOne
	@JoinColumn( name = "user_id")
	private User user;
	
	@OneToMany
	private List<Patient> patient;
	

}
