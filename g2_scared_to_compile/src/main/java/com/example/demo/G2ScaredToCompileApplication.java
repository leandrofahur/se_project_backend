package com.example.demo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	ApplicationRunner init(ProductRepository productRepository, CategoryRepository categoryRepository, InventoryRepository inventoryRepository, SessionRepository sessionRepository, CartRepository cartRepository) {
		return args -> {			
			
			
			Product[] products = {
				new Product("Product 01", "This is the product 01", 25.0f, "PRO-MED-WHI-COT"),
				new Product("Product 02", "This is the product 02", 15.0f, "PRO-LAG-BLA-COT"),
				new Product("Product 03", "This is the product 03", 5.0f, "PRO-SMA-GRA-COT")
			};
			
			Category[] categories = {
				new Category("Category 01", "This is the category 01"),
				new Category("Category 02", "This is the category 02")
			};
			
			Inventory[] inventories = {
					new Inventory(1),
					new Inventory(10),
					new Inventory(100)
				};
			
			products[0].addInventory(inventories[0]);
			products[1].addInventory(inventories[1]);
			products[2].addInventory(inventories[2]);
			
			categories[0].addProduct(products[0]);
			categories[0].addProduct(products[1]);
			categories[1].addProduct(products[1]);				
			
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
			
			for (int i = 0; i < categories.length; i++) {
				categoryRepository.save(categories[i]);
			}
			
			for (int i = 0; i < inventories.length; i++) {
				inventoryRepository.save(inventories[i]);
			}
			
			for (int i = 0; i < products.length; i++) {
				productRepository.save(products[i]);
			}
		};
	}
}
