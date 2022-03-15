package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.User;
import com.example.demo.models.UserAddress;
import com.example.demo.models.UserPayment;
import com.example.demo.models.UserPhone;
import com.example.demo.repositories.UserAddressRepository;
import com.example.demo.repositories.UserPaymentRepository;
import com.example.demo.repositories.UserPhoneRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.models.Cart;
import com.example.demo.models.Category;
import com.example.demo.models.Inventory;
import com.example.demo.models.Product;
import com.example.demo.repositories.CartRepository;
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
	ApplicationRunner init(UserRepository userRepository, UserPhoneRepository userPhoneRepository, UserAddressRepository userAddressRepository, UserPaymentRepository userPaymentRepository, ProductRepository productRepository, CategoryRepository categoryRepository, InventoryRepository inventoryRepository, SessionRepository sessionRepository, CartRepository cartRepository) {
		return args -> {			
			productRepository.save(new Product("Product 01", "This is the product 01", 25.0f, "PRO-MED-WHI-COT"));
			productRepository.save(new Product("Product 02", "This is the product 02", 25.0f, "PRO-LAG-BLA-COT"));
			productRepository.save(new Product("Product 03", "This is the product 03", 25.0f, "PRO-SMA-GRA-COT"));
			
			categoryRepository.save(new Category("Category 01", "This is the category 01"));
			categoryRepository.save(new Category("Category 02", "This is the category 02"));
			
			inventoryRepository.save(new Inventory(1));
			inventoryRepository.save(new Inventory(10));
			inventoryRepository.save(new Inventory(100));
			
			sessionRepository.save(new Session(10.0));
			sessionRepository.save(new Session(50.0));
			sessionRepository.save(new Session(100.0));
			sessionRepository.save(new Session(150.0));
			
			sessionRepository.save(new Session(10.0));
			sessionRepository.save(new Session(50.0));
			sessionRepository.save(new Session(100.0));
			sessionRepository.save(new Session(150.0));
			
			cartRepository.save(new Cart(1));
			cartRepository.save(new Cart(2));
			cartRepository.save(new Cart(3));
      
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
		
			userRepository.findAll().forEach(System.out::println);
			userPhoneRepository.findAll().forEach(System.out::println);
			userAddressRepository.findAll().forEach(System.out::println);
			userPaymentRepository.findAll().forEach(System.out::println);
		};
	}
}
