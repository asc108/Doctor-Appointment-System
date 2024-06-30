package com.root.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.root.controller.dto.ChangePasswordDTO;
import com.root.controller.dto.ChangeRoleDTO;
import com.root.controller.dto.NewUserRequest;
import com.root.model.User;
import com.root.repository.UserRepository;
import com.root.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final JwtService jwtService;

	public void registerUser(NewUserRequest request) {
		User user = User.builder().username(request.username()).password(passwordEncoder().encode(request.password()))
				.firstname(request.firstName()).lastname(request.lastName()).email(request.email()).number(request.number()).role("USER").build();
		User u = userRepository.findByUsername(request.username());
		if(u == null) {
			userRepository.save(user);
		} else {
			throw new IllegalArgumentException("Already registered");
		}

	}

	
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	public List<User> getAllUsers() {
		List<User> lista = userRepository.findAll();
		return lista;
	}

	public void removeUser(String username) {
		User user = userRepository.findByUsername(username);
		userRepository.delete(user);
	}

	public User findUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	public void changePassword(String username, ChangePasswordDTO request) {
		User user = userRepository.findByUsername(username);
		user.setPassword(request.password());
		
	}
	public String generateToken(String username) {
		return jwtService.generateToken(username);

	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}


	public void changeRole(ChangeRoleDTO request) {
		User user = userRepository.findByUsername(request.username());
		user.setRole(request.role());
		userRepository.save(user);
		
	}

}
