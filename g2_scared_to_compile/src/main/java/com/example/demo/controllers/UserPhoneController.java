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
import com.example.demo.models.UserPhone;
import com.example.demo.repositories.UserPhoneRepository;
import com.example.demo.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserPhoneController {
	
	@Autowired
	UserPhoneRepository userPhoneRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/userPhones/{id}")
	public ResponseEntity<UserPhone> getUserPhoneById(@PathVariable("id") long id){
		Optional<UserPhone> userPhoneData = userPhoneRepository.findById(id);
		
		if(userPhoneData.isPresent()) {
			return new ResponseEntity<>(userPhoneData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/userPhones")
	public ResponseEntity<List<UserPhone>> getAllUserPhone(){
		
		try {
			List<UserPhone> userPhones = new ArrayList<UserPhone>();
			userPhoneRepository.findAll().forEach(userPhones::add);
			return new ResponseEntity<>(userPhones, HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/userPhones/{user_id}")
	public ResponseEntity<UserPhone> createUserPhone(@RequestBody UserPhone userPhone, @PathVariable("user_id") long userId){
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			
			User existtUser = user.get();
			
			//UserPhone _userPhone = userPhoneRepository.save(new UserPhone(userPhone.getNumber()));
			
			userPhone.setCreatedAt(new Date());
			existtUser.addUserPhoneInfo(userPhone);
			
			userRepository.save(existtUser);
			
			return new ResponseEntity<>(userPhone, HttpStatus.CREATED);
		}
		
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		
	}
	
	@PutMapping("/userPhones/{id}")
	public ResponseEntity<UserPhone> updateUserPhone(@PathVariable("id") long id, @RequestBody UserPhone userPhone){
		
		
		if(userPhone.getNumber() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		} else {
			Optional<UserPhone> userPhoneData = userPhoneRepository.findById(id);
		
			if(userPhoneData.isPresent()) {
				
				UserPhone _userPhone = userPhoneData.get();
				_userPhone.setNumber(userPhone.getNumber());
				_userPhone.setUpdatedAt(new Date());
				
				return new ResponseEntity<>(userPhoneRepository.save(_userPhone), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	}
	
	@DeleteMapping("/userPhones/{id}")
	public ResponseEntity<HttpStatus> deleteUserPhoneById(@PathVariable("id") long id) {
		try {
			userPhoneRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/userPhones")
	public ResponseEntity<HttpStatus> deleteAllUserPhones() {
		try {
			userPhoneRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}





