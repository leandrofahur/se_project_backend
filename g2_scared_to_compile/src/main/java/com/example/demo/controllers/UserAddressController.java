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
import com.example.demo.models.UserAddress;
import com.example.demo.repositories.UserAddressRepository;
import com.example.demo.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserAddressController {
	
	@Autowired
	UserAddressRepository userAddressRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/userAddresses/{id}")
	public ResponseEntity<UserAddress> getUserAddressById(@PathVariable("id") long id){
		Optional<UserAddress> userAddressData = userAddressRepository.findById(id);
		
		if(userAddressData.isPresent()) {
			return new ResponseEntity<>(userAddressData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/userAddresses")
	public ResponseEntity<List<UserAddress>> getAllUserAddress(){
		
		try {
			List<UserAddress> userAddress = new ArrayList<UserAddress>();
			userAddressRepository.findAll().forEach(userAddress::add);
			return new ResponseEntity<>(userAddress, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/userAddresses/{user_id}")
	public ResponseEntity<UserAddress> createUserAddress(@RequestBody UserAddress userAddress, @PathVariable("user_id") long userId){
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isPresent()) {
			
			User existtUser = user.get();
			
//			UserAddress _userAddress = new UserAddress(
//					userAddress.getAddressLine1(), userAddress.getAddressLine2(),
//					userAddress.getCity(), userAddress.getProvince(), 
//					userAddress.getCountry(), userAddress.getPostalCode());
			userAddress.setCreatedAt(new Date());
			existtUser.addUserAddressInfo(userAddress);
			
			userRepository.save(existtUser);
			
			return new ResponseEntity<>(userAddress, HttpStatus.CREATED);
		}
		
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@PutMapping("/userAddresses/{id}")
	public ResponseEntity<UserAddress> updateUserAddress(@PathVariable("id") long id, @RequestBody UserAddress userAddress) {
		
		if(userAddress.getAddressLine1() == null
				|| userAddress.getCity() == null
				|| userAddress.getProvince() == null 
				|| userAddress.getCountry() == null 
				|| userAddress.getPostalCode() == null) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
			
		} else {
			
		Optional<UserAddress> userAddressData = userAddressRepository.findById(id);
			
			if(userAddressData.isPresent()) {
				UserAddress _userAddress = userAddressData.get();
				_userAddress.setAddressLine1(userAddress.getAddressLine1());
				_userAddress.setAddressLine2(userAddress.getAddressLine2());
				_userAddress.setCity(userAddress.getCity());
				_userAddress.setProvince(userAddress.getProvince());
				_userAddress.setCountry(userAddress.getCountry());
				_userAddress.setPostalCode(userAddress.getPostalCode());
				_userAddress.setUpdatedAt(new Date());
				
				return new ResponseEntity<>(userAddressRepository.save(_userAddress), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	}
	
	@DeleteMapping("/userAddresses/{id}")
	public ResponseEntity<HttpStatus> deleteUserAddressById(@PathVariable("id") long id) {
		try {
			userAddressRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/userAddresses")
	public ResponseEntity<HttpStatus> deleteAllUserAddresses() {
		try {
			userAddressRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

}
