package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.User;
import com.example.demo.model.UserPhone;
import com.example.demo.repository.UserPhoneRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserRepository userRepository, UserPhoneRepository userPhoneRepository) {
		return args->{
			
//			userRepository.save(new User("Han-Do", "Lee", "HandsomeGuy", "12345L", true, "handolee@somewhere.com"));
//			userRepository.save(new User("Mariana", "Lima", "BeautifulGirl", "67890M", true, "mariana@somewhere.com"));
//			userRepository.save(new User("Sebastian", "Mendez", "CharmingGuy", "54321S", true, "sebastian@somewhere.com"));
//			userRepository.findAll().forEach(System.out::println);

			
			User[] users  = {
					new User("Han-Do", "Lee", "HandsomeGuy", "12345L", true, "handolee@somewhere.com"),
					new User("Mariana", "Lima", "BeautifulGirl", "67890M", true, "mariana@somewhere.com"),
					new User("Sebastian", "Mendez", "CharmingGuy", "54321S", true, "sebastian@somewhere.com")
			};
			
			UserPhone[] userPhoneInfo = {
					new UserPhone("604-123-4567"),
					new UserPhone("604-890-0987"),
					new UserPhone("604-654-3211")
			};
			
			users[0].addUserPhoneInfo(userPhoneInfo[0]);
			users[0].addUserPhoneInfo(userPhoneInfo[1]);
			users[1].addUserPhoneInfo(userPhoneInfo[2]);
			
			for(int i = 0; i < users.length; i++) {
				userRepository.save(users[i]);
			}
			
			for(int i = 0; i < userPhoneInfo.length; i++) {
				userPhoneRepository.save(userPhoneInfo[i]);
			}
			
			userRepository.findAll().forEach(System.out::println);
			userPhoneRepository.findAll().forEach(System.out::println);
			
		};//ending return 
		
	}

}
