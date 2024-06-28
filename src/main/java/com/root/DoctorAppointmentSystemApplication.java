package com.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.root.model.User;
import com.root.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@SpringBootApplication
public class DoctorAppointmentSystemApplication {
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(DoctorAppointmentSystemApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			User user = User.builder().username("superadmin").password(passwordEncoder().encode("12345")).email("dada@gmail.com").role("ADMIN").build();
			userRepository.save(user);
			
			
		};
	}
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
