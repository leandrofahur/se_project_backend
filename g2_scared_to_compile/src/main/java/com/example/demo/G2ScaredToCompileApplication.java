package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.User;
import com.example.demo.model.UserAddress;
import com.example.demo.model.UserPayment;
import com.example.demo.model.UserPhone;
import com.example.demo.repository.UserAddressRepository;
import com.example.demo.repository.UserPaymentRepository;
import com.example.demo.repository.UserPhoneRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class G2ScaredToCompileApplication {

	public static void main(String[] args) {
		SpringApplication.run(G2ScaredToCompileApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(UserRepository userRepository, UserPhoneRepository userPhoneRepository, UserAddressRepository userAddressRepository, UserPaymentRepository userPaymentRepository) {
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
			
			UserPhone[] userPhones = {
					new UserPhone("604-123-4567"),
					new UserPhone("604-890-0987"),
					new UserPhone("604-654-3211")
			};
			
			UserAddress[] userAddresses = {
					new UserAddress("123 Pine st","45 Green ave", "Vancouver", "British Columbia", "Canada", "A1B2C3"),
					new UserAddress("67 54th st","89 Tree st", "New Westminster", "British Columbia", "Canada", "D4E5F6"),
					new UserAddress("501 29th st","21 Main st", "Burnaby", "British Columbia", "Canada", "G7H8I9K")
			};
			
			String strDate = "yyyy-MM-dd";
			SimpleDateFormat dateFormat = new SimpleDateFormat(strDate);
			Date date1 = dateFormat.parse("2024-07-15");
			Date date2 = dateFormat.parse("2025-09-23");
			Date date3 = dateFormat.parse("2023-04-02");
			
			UserPayment[] userPayments = {
					new UserPayment("1234 5678 8765 4321", date1, "123"),
					new UserPayment("1234 5678 8765 4321", date2, "123"),
					new UserPayment("1234 5678 8765 4321", date3, "123")
			};
			
			users[0].addUserPhoneInfo(userPhones[0]);
			users[0].addUserPhoneInfo(userPhones[1]);
			users[1].addUserPhoneInfo(userPhones[2]);
			
			users[0].addUserAddressInfo(userAddresses[0]);
			users[1].addUserAddressInfo(userAddresses[1]);
			users[2].addUserAddressInfo(userAddresses[2]);
			
			users[0].addUserPaymentInfo(userPayments[0]);
			users[1].addUserPaymentInfo(userPayments[1]);
			users[2].addUserPaymentInfo(userPayments[2]);
			
			
			
			for(int i = 0; i < users.length; i++) {
				userRepository.save(users[i]);
			}
			
			for(int i = 0; i < userPhones.length; i++) {
				userPhoneRepository.save(userPhones[i]);
			}
			
			for(int i = 0; i < userAddresses.length; i++) {
				userAddressRepository.save(userAddresses[i]);
			}
			
			for(int i = 0; i < userPayments.length; i++) {
				userPaymentRepository.save(userPayments[i]);
			}
	
			
			userRepository.findAll().forEach(System.out::println);
			userPhoneRepository.findAll().forEach(System.out::println);
			userAddressRepository.findAll().forEach(System.out::println);
			userPaymentRepository.findAll().forEach(System.out::println);
			
			
		};//ending return 
		
	}

}
