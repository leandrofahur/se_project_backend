package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.UserPhone;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {
	
	Optional<UserPhone> findById(long id);
	
	Boolean existsById(long id);

}
