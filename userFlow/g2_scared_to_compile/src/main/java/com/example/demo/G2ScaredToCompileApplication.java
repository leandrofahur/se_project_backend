package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserRepository userRepository) {
		return args->{
			
			userRepository.save(new User("Han-Do", "Lee", "HandsomeGuy", "12345L", true, "handolee@somewhere.com"));
			userRepository.save(new User("Mariana", "Lima", "BeautifulGirl", "67890M", true, "mariana@somewhere.com"));
			userRepository.save(new User("Sebastian", "Mendez", "CharmingGuy", "54321S", true, "sebastian@somewhere.com"));
			userRepository.findAll().forEach(System.out::println);
			
		};
		
	}

}
