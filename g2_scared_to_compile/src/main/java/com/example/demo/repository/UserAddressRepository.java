package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserAddress;
import com.example.demo.model.UserPhone;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

	Optional<UserAddress> findById(long id);
	
	Boolean existsById(long id);
	
}
