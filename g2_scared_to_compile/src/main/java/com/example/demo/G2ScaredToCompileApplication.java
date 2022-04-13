package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
		
	}
	
	@Bean
	ApplicationRunner init() {
		return args -> {			
			System.out.println("Guess who's back...");
		};
	}
}
