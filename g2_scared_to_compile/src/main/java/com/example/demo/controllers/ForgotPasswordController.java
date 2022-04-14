package com.example.demo.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.client.security.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Inventory;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ForgotPasswordService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ForgotPasswordController {
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/forgotpassword")
	public ResponseEntity<String> getForgotPasswordEmailNotification(@RequestBody Object emailObject){
		try {
			String email = emailObject.toString().replace('}', ' ').substring(7);			
			System.out.println(email.trim());
			Optional<com.example.demo.models.User> _user = userRepository.findByEmail(email.trim());
			
			if(_user.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
			}
			
			forgotPasswordService.SendForgotPassword(_user.get());
			return new ResponseEntity<>("Check your email box", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/secretpath/resetpassword")
	public ResponseEntity<String> resetPassord(@RequestBody Object resetPasswordObject){
		try {
			String[] object = resetPasswordObject.toString().replace('}', ' ').substring(7).split(",");			
			
			String email = object[0];
			String password = object[1].substring(10).trim();
			
			Optional<com.example.demo.models.User> userData = userRepository.findByEmail(email);
			
			if(userData.get().getEmail().equals(email)) {
				com.example.demo.models.User _user = userData.get();
				_user.setPassword(password);				
				_user.setEmail(email);
				_user.setUpdatedAt(new Date());
				userRepository.save(_user);
			
				return new ResponseEntity<>("Password changed!", HttpStatus.OK);				
			}				
			
			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
