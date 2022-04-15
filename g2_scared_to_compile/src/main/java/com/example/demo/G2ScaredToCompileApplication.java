package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
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
import com.example.demo.models.Discount;
import com.example.demo.models.Inventory;
import com.example.demo.models.Product;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.DiscountRepository;
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
	ApplicationRunner init(UserRepository userRepository, UserPhoneRepository userPhoneRepository, UserAddressRepository userAddressRepository, UserPaymentRepository userPaymentRepository, ProductRepository productRepository, CategoryRepository categoryRepository, InventoryRepository inventoryRepository, SessionRepository sessionRepository, CartRepository cartRepository, DiscountRepository discountRepository) {
    
		return args -> {			
			
			Product[] products = {
				new Product("Shoe Vermei", "This is the product 01", 125.0f, "PRO-MED-WHI-COT", "shoe01.png"),
				new Product("Shoe verdi", "This is the product 02", 151.0f, "PRO-LAG-BLA-COT", "shoe02.png"),
				new Product("Shoe Amoado", "This is the product 03", 500.0f, "PRO-SMA-GRA-COT", "shoe03.png"),
				new Product("Shoe Voanu", "This is the product 04", 50.0f, "PRO-AMS-ARG-TOC", "shoe04.png")
			};
			
			Category[] categories = {
				new Category("All", "This is the category 01"),
				new Category("Women", "This is the category 02"),
				new Category("Men", "This is the category 03")
			};
			
			Inventory[] inventories = {
					new Inventory(1),
					new Inventory(10),
					new Inventory(100)
				};
			
			products[0].addInventory(inventories[0]);
			//products[0].addInventory(inventories[1]);
			products[1].addInventory(inventories[1]);
			products[2].addInventory(inventories[2]);
			
			categories[0].addProduct(products[0]);
			categories[0].addProduct(products[1]);
			categories[0].addProduct(products[2]);
			categories[0].addProduct(products[3]);
			
			categories[1].addProduct(products[0]);
			categories[1].addProduct(products[1]);
			
			categories[2].addProduct(products[2]);
			categories[2].addProduct(products[3]);
			
			Discount [] discounts = {
				new Discount("Discount 01", "Description1", 25, true),
				new Discount("Discount 02", "Description2", 25, true),
				new Discount("Discount 03", "Description3", 25, true),
				new Discount("Discount 04", "Description4", 25, true),
				new Discount("Discount 05", "Description5", 25, false),
				new Discount("Discount 06", "Description6", 25, false)
			};
			
			sessionRepository.save(new Session(10.0));
			sessionRepository.save(new Session(50.0));
			sessionRepository.save(new Session(100.0));
			sessionRepository.save(new Session(150.0));
			
			sessionRepository.save(new Session(10.0));
			sessionRepository.save(new Session(50.0));
			sessionRepository.save(new Session(100.0));
			sessionRepository.save(new Session(150.0));
			
			/*
			 * cartRepository.save(new Cart(1)); cartRepository.save(new Cart(2));
			 * cartRepository.save(new Cart(3));
			 */


			
			for (int i = 0; i < categories.length; i++) {
				categoryRepository.save(categories[i]);
			}
			
			for (int i = 0; i < inventories.length; i++) {
				inventoryRepository.save(inventories[i]);
			}
			
			for (int i =0;i<discounts.length; i++) {	
				discountRepository.save(discounts[i]);
			}
			
			for (int i = 0; i < products.length; i++) {
				productRepository.save(products[i]);
			}
      
			User[] users  = {
					new User("Leandro", "Machado", "Han-Do", "12345L", true, "g2scaredtocompile@gmail.com"),
					new User("Mariana", "Lima", "Mari", "67890M", true, "mariana@somewhere.com"),
					new User("Sebastian", "Mendez", "Seth", "54321S", true, "sebastian@somewhere.com")
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
