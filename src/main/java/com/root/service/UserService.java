package com.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.root.controller.dto.ChangePasswordDTO;
import com.root.controller.dto.NewUserRequest;
import com.root.model.User;
import com.root.model.UserRole;
import com.root.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public void registerUser(NewUserRequest request) {
		User user = User.builder().username(request.username()).password(passwordEncoder().encode(request.password()))
				.email(request.email()).number(request.number()).userRole(UserRole.PATIENT).build();
		User u = userRepository.findUserByUsername(request.username());
		if(u == null) {
			userRepository.save(user);
		} else {
			throw new IllegalArgumentException("Already registered");
		}

	}

	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	public List<User> getAllUsers() {
		List<User> lista = userRepository.findAll();
		return lista;
	}

	public void removeUser(String username) {
		User user = userRepository.findUserByUsername(username);
		userRepository.delete(user);
	}

	public User getAllUsers(String username) {
		User user = userRepository.findUserByUsername(username);
		return user;
	}

	public void changePassword(String username, ChangePasswordDTO request) {
		User user = userRepository.findUserByUsername(username);
		user.setPassword(request.password());
		
	}

}
