package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Inventory;
import com.example.demo.repositories.InventoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class ProductInventoryController {
	@Autowired
	InventoryRepository inventoryRepository;
	
	// ----------
	@GetMapping("/inventories")
	public ResponseEntity<List<Inventory>> getAllInventories() {
		try {
			List<Inventory> listOfInventories = new ArrayList<>();
			
			inventoryRepository.findAll().forEach(listOfInventories::add);
			return new ResponseEntity<>(listOfInventories, HttpStatus.OK);
			
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
}
