package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Discount;
import com.example.demo.repositories.DiscountRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class DiscountController {
	@Autowired
	DiscountRepository discountRepository;

	@GetMapping("/discounts")
	public ResponseEntity<List<Discount>> getAllDiscounts(@RequestParam(required = false) String name){
		try {
			if(name != null) {
				List<Discount> discounts = discountRepository.findByName(name);
				return new ResponseEntity<>(discounts, HttpStatus.OK);
			}
				List<Discount> discounts = discountRepository.findAll();
			if(discounts.size()==0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(discounts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/discounts") 
	public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount){
		try {
			Discount _discount = discountRepository.save(new Discount(discount.getName(), discount.getDescription(), discount.getDiscountPercentage(),discount.isActive()));		
			return new ResponseEntity<>(_discount, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/discounts/{id}")
	public ResponseEntity<Discount> updateDiscount(@PathVariable("id") long id, @RequestBody Discount updateDiscount) {
		Optional<Discount> discount = discountRepository.findById(id);
		
		if(discount.isPresent()) {
			Discount _discount = discount.get();
			_discount.setName(updateDiscount.getName());
			_discount.setDescription(updateDiscount.getDescription());
			_discount.setDiscountPercentage(updateDiscount.getDiscountPercentage());
			_discount.setActive(updateDiscount.isActive());
			return new ResponseEntity<>(discountRepository.save(_discount), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}			
	}
	
	@DeleteMapping("/discounts")
	public ResponseEntity<HttpStatus> deleteAllDiscounts() {		
		try {					
			discountRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}
	
	@DeleteMapping("/discounts/{id}")
	public ResponseEntity<HttpStatus> deleteDiscountById(@PathVariable("id") long id) {		
		try {						
			discountRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}	
}
