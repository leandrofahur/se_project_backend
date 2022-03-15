package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.Session;
import com.example.demo.repositories.SessionRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")


public class SessionController {
	
	@Autowired
	SessionRepository sessionRepository;
	
	
	//Get All 
	@GetMapping("/session")
	public ResponseEntity<List<Session>> GetSessions() {
		
		try {
			List<Session> sessionList = new ArrayList<>();
			
			sessionRepository.findAll().forEach(sessionList::add);
			
			return new ResponseEntity<>(sessionList, HttpStatus.OK);
			
		} catch(Exception ex) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get by ID
	@GetMapping("/session/{id}")
	public ResponseEntity<Session> GetById(@PathVariable("id") long id) {
		
		Optional<Session> session = sessionRepository.findById(id);
		
		if (session.isPresent()) {
			return new ResponseEntity<>(session.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Insert
	@PostMapping("/session")
	public ResponseEntity<Session> InsertSession(@RequestBody Session newSession) {
		
		try {
			Session session = sessionRepository.save(new Session(newSession.getTotal()));
			return new ResponseEntity<>(session, HttpStatus.CREATED);
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Update
	@PutMapping("/session/{id}")
	public ResponseEntity<Session> UpdateById(@PathVariable("id") long id, @RequestBody Session newSession) {
		
		Optional<Session> session = sessionRepository.findById(id);

		if (session.isPresent()) {
			Session updatedSession = session.get();
			updatedSession.setTotal(newSession.getTotal());
			
			return new ResponseEntity<>(sessionRepository.save(updatedSession), HttpStatus.OK);
		
		} else {
			
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete by ID
	@DeleteMapping("/session/{id}")
	public ResponseEntity<Session> DeleteById(@PathVariable("id") long id) {

		try {
			sessionRepository.deleteById(id);
			
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			
		} catch (Exception ex) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Delete All
	@DeleteMapping("/session")
	public ResponseEntity<Session> DeleteAll() {
		
		try {
			sessionRepository.deleteAll();
			
			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			
		} catch (Exception ex) {
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
