package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(ProductRepository productRepository, CategoryRepository categoryRepository) {
		return args -> {
			//productRepository.save(new Product("Product 01", "This is the first produt of our business", 10.00f, "TSH-MED-WHI-COT"));
			//productRepository.save(new Product("Product 02", "This is the second produt of our business", 12.50f, "JEA-MED-BLU-COT"));			
			//productRepository.findAll().forEach(System.out::println);
			
			//categoryRepository.save(new Category("Category 01", "This is the first produt category of our business"));
			//categoryRepository.save(new Category("Category 02", "This is the second produt category of our business"));			
			//categoryRepository.findAll().forEach(System.out::println);
			
			Category c1 = new Category("Clothes", "The best fabric in the market");
			Category c2 = new Category("Food", "High quality for high demanding market");
			
			Product p1 = new Product("Kat Can", "Her a miau from opening the tuna can", 1.99f, "TUN-CAT-FIS-TUN");
			Product p2 = new Product("Bread", "Tastes like it's freshly baked", 2.50f, "BRE-HUM-FLO-CAR");
			Product p3 = new Product("Hat", "Protect your head from the sun", 12.00f, "HAT-MED-BLC-COT");
		
			c1.getProducts().addAll(Arrays.asList(p1,p2));
			c2.getProducts().addAll(Arrays.asList(p3));
			
			p1.getCategories().addAll(Arrays.asList(c2));
			p2.getCategories().addAll(Arrays.asList(c2));
			p3.getCategories().addAll(Arrays.asList(c1));
			
			categoryRepository.saveAll(Arrays.asList(c1,c2));
			productRepository.saveAll(Arrays.asList(p1,p2,p3));
		};
	}

}
