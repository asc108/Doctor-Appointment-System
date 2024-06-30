package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.model.MedicalRecord;

public interface RecordRepository extends JpaRepository<MedicalRecord, Integer> {

}
