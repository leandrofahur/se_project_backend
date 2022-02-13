package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(ProductRepository productRepository) {
		return args -> {
			// https://www.tradegecko.com/free-tools/sku-generator
			productRepository.save(new Product("Product 01", "This is the first produt of our business", 10.00f, "TSH-MED-WHI-COT"));
			productRepository.save(new Product("Product 02", "This is the second produt of our business", 12.50f, "JEA-MED-BLU-COT"));			
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
