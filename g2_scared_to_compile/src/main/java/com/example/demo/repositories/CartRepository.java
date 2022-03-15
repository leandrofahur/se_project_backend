package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Optional<Cart> findById(long id);
}
