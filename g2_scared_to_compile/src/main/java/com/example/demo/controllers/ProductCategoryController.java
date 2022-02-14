package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductCategoryController {
	@Autowired
	CategoryRepository productCategoryRepository;
	
	// ----------
		@GetMapping("/categories")
		public ResponseEntity<List<Category>> getAllProducts(@RequestParam(required=false) String name) {
			try {
				List<Category> listOfCategories = new ArrayList<>();
				if(name == null) {
					productCategoryRepository.findAll().forEach(listOfCategories::add);
				} else {
					productCategoryRepository.findByName(name).forEach(listOfCategories::add);
				}
							
				return new ResponseEntity<>(listOfCategories, HttpStatus.OK);
				
			} catch(Exception ex) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
			}		
		}
}
