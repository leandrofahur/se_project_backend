package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Category;
import com.example.demo.models.Inventory;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.InventoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.models.Session;
import com.example.demo.repositories.SessionRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
		
	}
	
	@Bean
	ApplicationRunner init(ProductRepository productRepository, CategoryRepository categoryRepository, InventoryRepository inventoryRepository) {
		return args -> {			
			productRepository.save(new Product("Product 01", "This is the product 01", 25.0f, "PRO-MED-WHI-COT"));
			productRepository.save(new Product("Product 02", "This is the product 02", 25.0f, "PRO-LAG-BLA-COT"));
			productRepository.save(new Product("Product 03", "This is the product 03", 25.0f, "PRO-SMA-GRA-COT"));
			
			categoryRepository.save(new Category("Category 01", "This is the category 01"));
			categoryRepository.save(new Category("Category 02", "This is the category 02"));
			
			inventoryRepository.save(new Inventory(1));
			inventoryRepository.save(new Inventory(10));
			inventoryRepository.save(new Inventory(100));
		};
	}
}
