package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	// ----------
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required=false) String name) {
		try {
			List<Product> listOfProducts = new ArrayList<>();
			if(name == null) {
				productRepository.findAll().forEach(listOfProducts::add);
			} else {
				productRepository.findByName(name).forEach(listOfProducts::add);
			}
						
			return new ResponseEntity<>(listOfProducts, HttpStatus.OK);
			
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> product = productRepository.findById(id);
			
		if(product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	// ----------	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
		try {
			Product product = productRepository.save(new Product(newProduct.getName(), newProduct.getDescription(), newProduct.getPrice(), newProduct.getSKU(), newProduct.getProductPic()));
			return new ResponseEntity<>(product, HttpStatus.OK);			
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	// TODO: Route to add category inside the product
	
	// ----------
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product updatedProduct) {
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isPresent()) {
			Product _product = product.get();
			_product.setName(updatedProduct.getName());
			_product.setDescription(updatedProduct.getDescription());
			_product.setPrice(updatedProduct.getPrice());
			_product.setSKU(updatedProduct.getSKU());
			_product.setIsFavorite(updatedProduct.getIsFavorite());
			_product.setUpdatedAt(new Date());
			
			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}				
	}
	
	// TODO: Route to update category inside the product
	
	// ----------
	@DeleteMapping("/products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {		
		try {					
			productRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<HttpStatus> deleteProductById(@PathVariable("id") long id) {		
		try {					
			productRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}
	
	// TODO: Delete category inside the product
	
}
