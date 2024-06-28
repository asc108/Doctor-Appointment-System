package com.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

}
