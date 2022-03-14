package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserPayment;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

	Optional<UserPayment> findById(long id);
	
	Boolean existsById(long id);
	
}