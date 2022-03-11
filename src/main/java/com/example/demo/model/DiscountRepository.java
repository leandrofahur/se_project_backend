package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
	
	List<Discount> findByName(String name);
	List<Discount> findByDescription(String description);
	List<Discount> findByDiscountPercentage(float discount_percentage);
	List<Discount> findByIsActive(boolean is_alive);

}
