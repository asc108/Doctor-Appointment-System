package com.root.controller.dto;

import java.sql.Date;

public record PatientRequestDTO(String firstname,String lastname,Date date,String contactInfo,String additionalInfo) {

}
