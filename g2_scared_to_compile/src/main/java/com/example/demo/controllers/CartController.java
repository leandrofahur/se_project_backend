package com.example.demo.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Cart;
import com.example.demo.repositories.CartRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class CartController {

	@Autowired
	CartRepository cartRepository;
	
	//Get All
	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> GetAll() {
		
		try {
			List<Cart> cartsList = new ArrayList<>();
			
			cartRepository.findAll().forEach(cartsList::add);
			
			return new ResponseEntity<>(cartsList, HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get Cart by ID
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> GetById(@PathVariable("id") long id) {
		
		Optional<Cart> cart = cartRepository.findById(id);
		
		if (cart.isPresent()) {
			
			return new ResponseEntity<>(cart.get(), HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//Insert
	@PostMapping("/cart")
	public ResponseEntity<Cart> Insert(@RequestBody Cart newCart) {
		try {
			Cart cart = cartRepository.save(new Cart(newCart.getSessionId(), newCart.getProductId(), newCart.getQuantity()));
			return new ResponseEntity<>(cart, HttpStatus.CREATED);
			
		} catch (Exception ex) {
			
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update
	@PutMapping("/cart/{id}")
	public ResponseEntity<Cart> UpdateById(@PathVariable("id") long id, @RequestBody Cart newCart) {
		
		Optional <Cart> cart = cartRepository.findById(id);
		
		if (cart.isPresent()) {
			Cart updatedCart = cart.get();
			updatedCart.setQuantity(newCart.getQuantity());
			
			return new ResponseEntity<>(cartRepository.save(updatedCart), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete by ID
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<Cart> DeleteById(@PathVariable("id") long id) {
		
		try {
			cartRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete All
	@DeleteMapping("/cart")
	public ResponseEntity<Cart> DeleteAll() {
		
		try {
			cartRepository.deleteAll();
			
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			
		} catch (Exception ex) {
			
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
