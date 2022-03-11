package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Discount;
import com.example.demo.model.DiscountRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
	}
	
	@Bean ApplicationRunner init(DiscountRepository discountRepository) {
		return args ->{
			
			Discount [] discounts = {new Discount("Sebastian", "Description1", 25, true),
									 new Discount("Leandro", "Description2", 25, true),
									 new Discount("Mariana", "Description3", 25, true),
									 new Discount("Sung Ah", "Description4", 25, true),
									 new Discount("Sebastian", "Description5", 25, false),
									 new Discount("Leandro", "Description6", 25, false)
			};
			
			for (int i =0;i<discounts.length; i++) {
				
				discountRepository.save(discounts[i]);
			}
			
			discountRepository.findAll().forEach(System.out::println);
			
		};
	}

}
