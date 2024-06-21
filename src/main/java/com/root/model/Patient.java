package com.root.model;

import java.sql.Date;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int id;

	private String first_name;
	private String last_name;
	private Date dateOfBirth;
	private String contactInfo;
	@Column(columnDefinition = "LONGTEXT")
	private String additionalInfo;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	

}
