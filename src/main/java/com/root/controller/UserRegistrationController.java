package com.root.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.root.controller.dto.ChangePasswordDTO;
import com.root.controller.dto.NewUserRequest;
import com.root.model.User;
import com.root.service.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class UserRegistrationController {

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody NewUserRequest request) {
		try {
			userService.registerUser(request);
			return new ResponseEntity<>("Succsessfull registration", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<String> removeUser(@PathVariable String username) {
		try {
			userService.removeUser(username);
			return ResponseEntity.ok("Sucssessfull");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}
	
	@GetMapping("/get/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getAllUsers(username);
	}
	
	@PatchMapping("/{username}")
	public ResponseEntity<String> changePassword(@PathVariable("username") String username,@RequestBody ChangePasswordDTO request) { 
		try {
			userService.changePassword(username,request);
			return new ResponseEntity<>("Successfull password change",HttpStatus.OK);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}
		
	}

}
