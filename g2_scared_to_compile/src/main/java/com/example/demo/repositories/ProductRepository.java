package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Optional<Product> findById(long id);
	
	List<Product> findByName(String name);
}
