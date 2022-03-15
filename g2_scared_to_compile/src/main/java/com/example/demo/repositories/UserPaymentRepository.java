package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.UserPayment;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

	Optional<UserPayment> findById(long id);
	
	Boolean existsById(long id);
	
}
