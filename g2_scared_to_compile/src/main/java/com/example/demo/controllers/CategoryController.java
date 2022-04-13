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

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	// ----------
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required=false) String name) {
		try {
			List<Category> listOfCategories = new ArrayList<>();
			if(name == null) {
				categoryRepository.findAll().forEach(listOfCategories::add);
			} else {
				categoryRepository.findByName(name).forEach(listOfCategories::add);
			}
							
			return new ResponseEntity<>(listOfCategories, HttpStatus.OK);
				
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
		Optional<Category> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			return new ResponseEntity<>(category.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
				
	}
	
	// ----------	
	@PostMapping("/categories")
	public ResponseEntity<Category> createCategory(@RequestBody Category newCategory) {
		try {
			Category category = categoryRepository.save(new Category(newCategory.getName(), newCategory.getDescription()));				
			return new ResponseEntity<>(category, HttpStatus.OK);			
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	// ----------	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category updateCategory) {
		Optional<Category> category = categoryRepository.findById(id);
		
		if(category.isPresent()) {
			Category _category = category.get();
			_category.setName(updateCategory.getName());
			_category.setDescription(updateCategory.getDescription());
			_category.setUpdatedAt(new Date());
			
			return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}			
	}
	
	// ----------	
	@DeleteMapping("/categories")
	public ResponseEntity<HttpStatus> deleteAllCategories() {		
		try {					
			categoryRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
						
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<HttpStatus> deleteCategoryById(@PathVariable("id") long id) {		
		try {						
			categoryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}					
	}
}
