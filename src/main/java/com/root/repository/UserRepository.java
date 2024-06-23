package com.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.root.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);

	

	

	
}
