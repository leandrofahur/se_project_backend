package com.example.demo.controller;

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

import com.example.demo.model.UserAddress;
import com.example.demo.repository.UserAddressRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserAddressController {
	
	@Autowired
	UserAddressRepository userAddressRepository;
	
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
	
//	@PostMapping("/userAddresses")
//	public ResponseEntity<UserAddress> createUserAddress(@RequestBody UserAddress userAddress){
//		
//		try {
//			UserAddress _userAddress 
//			= userAddressRepository.save(new UserAddress(userAddress.getAddressLine1(), userAddress.getAddressLine2(),
//					userAddress.getCity(), userAddress.getProvince(), userAddress.getCountry(), userAddress.getPostalCode()));
//			return new ResponseEntity<>(_userAddress, HttpStatus.CREATED);
//		}catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PutMapping("/userAddresses/{id}")
//	public ResponseEntity<UserAddress> updateUserAddress(@PathVariable("id") long id, @RequestBody UserAddress userAddress){
//		Optional<UserAddress> userAddressData = userAddressRepository.findById(id);
//		
//		if(userAddressData.isPresent()) {
//			UserAddress _userAddress = userAddressData.get();
//			_userAddress.setAddressLine1(userAddress.getAddressLine1());
//			_userAddress.setAddressLine2(userAddress.getAddressLine2());
//			_userAddress.setCity(userAddress.getCity());
//			_userAddress.setProvince(userAddress.getProvince());
//			_userAddress.setCountry(userAddress.getCountry());
//			_userAddress.setPostalCode(userAddress.getPostalCode());
//			_userAddress.setUpdatedAt(new Date());
//			
//			return new ResponseEntity<>(userAddressRepository.save(_userAddress), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
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
