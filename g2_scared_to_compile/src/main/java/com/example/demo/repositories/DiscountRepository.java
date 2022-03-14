package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{
	Optional<Discount> findById(long id);
	List<Discount> findByName(String name);
	List<Discount> findByDescription(String description);
	List<Discount> findByDiscountPercentage(float discount_percentage);
	List<Discount> findByIsActive(boolean is_alive);
}
