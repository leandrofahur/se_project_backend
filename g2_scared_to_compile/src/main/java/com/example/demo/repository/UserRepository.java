package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);
	List<User> findByUserName(String userName);
	List<User> findByPassword(String password);
	List<User> findByIsAdmin(boolean isAdmin);
	List<User> findByEmail(String email);

}
