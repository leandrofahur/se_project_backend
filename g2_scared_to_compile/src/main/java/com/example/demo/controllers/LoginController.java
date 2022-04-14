package com.example.demo.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.request.UserLoginRequest;
import com.example.demo.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginController {
	 
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequest loginRequest){
		
//		try {
			Optional<User> userData = userRepository.findByEmail(loginRequest.getEmail());
			
			if(userData.isPresent()) {
				String password = userData.get().getPassword();
				if(password.equals(loginRequest.getPassword())) {
					return new ResponseEntity<>(userData.get(),HttpStatus.OK);
				}
				//MessageResponse msg = new MessageResponse("Incorrect password");
				return new ResponseEntity<>("Incorrect password",HttpStatus.NOT_FOUND);
			}
			//MessageResponse msg = new MessageResponse("No such a user");
			return new ResponseEntity<>("No such a user",HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			MessageResponse msg = new MessageResponse("Server Error");
//			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<User> login(@Valid @RequestBody UserLoginRequest loginRequest){
//		
//	
//			Optional<User> userData = userRepository.findByEmail(loginRequest.getEmail());
//			
//			if(userData.isPresent()) {
//				String password = userData.get().getPassword();
//		
//			return new ResponseEntity<>(userData.get(),HttpStatus.OK);
//		
//			
//			} else {
//	
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		
//		
//	}
	

}
