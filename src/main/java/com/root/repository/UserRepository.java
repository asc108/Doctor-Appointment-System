package com.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.root.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	//@Query(nativeQuery = true, value = "select * from user where firstname =: firstname and role = 'DOCTOR'; ")
	User findByFirstname(String firstname);

}
