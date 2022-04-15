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

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String userName){
		
		try {
			List<User> users = new ArrayList<>();
			
			if(userName == null) {
				userRepository.findAll().forEach(users::add);
			}else {
				userRepository.findByUserName(userName).forEach(users::add);
			}
			
			return new ResponseEntity<>(users,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id){
		Optional<User> userData = userRepository.findById(id);
		
		if(userData.isPresent()) {
			return new ResponseEntity<>(userData.get(),HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
//	@GetMapping("/users/{email}")
//	public ResponseEntity<User> getUserById(@PathVariable("email") String email){
//		Optional<User> userData = userRepository.findByEmail(email);
//		
//		if(userData.isPresent()) {
//			return new ResponseEntity<>(userData.get(),HttpStatus.OK);
//			
//		} else {
//			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//		}
//		
//	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		try {

//			User _user = userRepository.save(new User(user.getFirstName(), user.getLastName(),
//					user.getUserName(), user.getPassword(), user.getIsAdmin(), user.getEmail()));
			
			User _user = userRepository.save(new User(
					user.getUserName(),user.getEmail(), user.getPassword()));
			
//			User _user = userRepository.save(new User(
//					user.getUserName(),user.getEmail(), user.getPassword(), user.getPassword()));
			
			
			return new ResponseEntity<>(_user,HttpStatus.CREATED);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		Optional<User> userData = userRepository.findById(id);
		
		if(userData.isPresent()) {
			User _user = userData.get();
			_user.setFirstName(user.getFirstName());
			_user.setLastName(user.getLastName());
			_user.setUserName(user.getUserName());
//			_user.setPassword(user.getPassword());
//			_user.setIsAdmin(user.getIsAdmin());
			_user.setEmail(user.getEmail());
			_user.setUpdatedAt(new Date());
			
			return new ResponseEntity<>(userRepository.save(_user),HttpStatus.OK);
			
			
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users")
	public ResponseEntity<HttpStatus> deleteAllUser(){
		
		try {
			userRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") long id){
		try {
			userRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}















