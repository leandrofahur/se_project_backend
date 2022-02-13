package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findById(long id);
	
	List<Product> findByName(String name);
	
	// TODO: add methods for the new attributes
}
