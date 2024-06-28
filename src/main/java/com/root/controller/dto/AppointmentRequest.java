package com.root.controller.dto;

import java.time.LocalDateTime;

public record AppointmentRequest(LocalDateTime date,String info,String user,String doctor) {

}
	