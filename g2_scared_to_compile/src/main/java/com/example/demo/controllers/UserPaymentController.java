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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.models.UserPayment;
import com.example.demo.repositories.UserPaymentRepository;
import com.example.demo.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserPaymentController {
	
	@Autowired
	UserPaymentRepository userPaymentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/userPayments/{id}")
	public ResponseEntity<UserPayment> getUserPaymentById(@PathVariable("id") long id){
		Optional<UserPayment> userPaymentData = userPaymentRepository.findById(id);
		
		if(userPaymentData.isPresent()) {
			return new ResponseEntity<>(userPaymentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/userPayments")
	public ResponseEntity<List<UserPayment>> getAllUserPayments(){
		
		try {
			List<UserPayment> userPayments = new ArrayList<UserPayment>();
			userPaymentRepository.findAll().forEach(userPayments::add);
			return new ResponseEntity<>(userPayments,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/userPayments/{user_id}")
	public ResponseEntity<UserPayment> createUserPayment(@RequestBody UserPayment userPayment,  @PathVariable("user_id") long userId){
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			
			User existtUser = user.get();
			
//			UserPayment _userPayment 
//			= userPaymentRepository.save(
//					new UserPayment(userPayment.getCardNumber(), userPayment.getExpirationDate(), userPayment.getCvc()));
			
			userPayment.setCreatedAt(new Date());
			existtUser.addUserPaymentInfo(userPayment);
			
			userRepository.save(existtUser);
			
			return new ResponseEntity<>(userPayment, HttpStatus.CREATED);
			
		}
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PutMapping("/userPayments/{id}")
	public ResponseEntity<UserPayment> updateUserPayment(@PathVariable("id") long id, @RequestBody UserPayment userPayment){
		
		if(userPayment.getCardNumber() == null 
				|| userPayment.getExpirationDate() == null 
				|| userPayment.getCvc() == null) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		} else {
			
			Optional<UserPayment> userPaymentData = userPaymentRepository.findById(id);
			
			if(userPaymentData.isPresent()) {
				UserPayment _userPayment = userPaymentData.get();
				_userPayment.setCardNumber(userPayment.getCardNumber());
				_userPayment.setExpirationDate(userPayment.getExpirationDate());
				_userPayment.setCvc(userPayment.getCvc());
				_userPayment.setUpdatedAt(new Date());
				
				return new ResponseEntity<>(userPaymentRepository.save(_userPayment), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}	
	}
	
	@DeleteMapping("/userPayments/{id}")
	public ResponseEntity<HttpStatus> deleteUserPaymentById(@PathVariable("id") long id) {
		try {
			userPaymentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/userPayments")
	public ResponseEntity<HttpStatus> deleteAllUserPayments() {
		try {
			userPaymentRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

}
