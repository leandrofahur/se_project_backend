package com.example.demo.controllers;

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
import com.example.demo.request.UserSignUpRequest;
import com.example.demo.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SignupController {
	
	@Autowired
	UserRepository userRepository;
	
//	@PostMapping("/signup")
//	public ResponseEntity<?> createUser(@RequestBody UserSignUpRequest userSignUpRequest){
//		
//		try {
//			UserSignUpRequest _uSignup = userRepository.save(new UserSignUpRequest(
//					userSignUpRequest.getUserName(), userSignUpRequest.getEmail(), userSignUpRequest.getPassword(), userSignUpRequest.getConfirmPassword()));
//			
//		}catch (Exception e) {
//			MessageResponse msg = new MessageResponse("Server Error");
//			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
