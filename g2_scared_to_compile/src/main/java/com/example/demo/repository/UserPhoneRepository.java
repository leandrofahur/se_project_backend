package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserPhone;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {
	
	Optional<UserPhone> findById(String id);
	
	Boolean existsById(String id);

}
