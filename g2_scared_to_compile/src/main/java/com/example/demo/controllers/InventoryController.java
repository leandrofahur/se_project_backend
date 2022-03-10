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

import com.example.demo.models.Inventory;
import com.example.demo.repositories.InventoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class InventoryController {
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
	
	// ----------
	@GetMapping("/inventories/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") long id) {
			
		Optional<Inventory> inventory = inventoryRepository.findById(id);
		
		if(inventory.isPresent()) {
			return new ResponseEntity<>(inventory.get(), HttpStatus.OK);
		}
					
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);				
	}

	// ----------	
	@PostMapping("/inventories")
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory newInventory) {
		try {
			Inventory inventory = inventoryRepository.save(new Inventory(newInventory.getQuantity()));
			return new ResponseEntity<>(inventory, HttpStatus.OK);			
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	
	
	// ----------
	@PutMapping("/inventories/{id}")
	public ResponseEntity<Inventory> updateInventory(@PathVariable("id") long id, @RequestBody Inventory updatedInventory) {
		Optional<Inventory> inventory = inventoryRepository.findById(id);
		
		if(inventory.isPresent()) {
			Inventory _inventory = inventory.get();
			_inventory.setQuantity(updatedInventory.getQuantity());			
			_inventory.setUpdatedAt(new Date());
			
			return new ResponseEntity<>(inventoryRepository.save(_inventory), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}				
	}
	
	// ----------
	@DeleteMapping("/inventories")
	public ResponseEntity<HttpStatus> deleteAllInventories() {		
		try {					
			inventoryRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}
	
	@DeleteMapping("/inventories/{id}")
	public ResponseEntity<HttpStatus> deleteInventoryById(@PathVariable("id") long id) {		
		try {					
			inventoryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}
}
