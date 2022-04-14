package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);
	List<User> findByUserName(String userName);
	List<User> findByPassword(String password);
	List<User> findByIsAdmin(boolean isAdmin);
	//List<User> findByEmail(String email);
	
	Optional<User> findById(long id);
	Optional<User> findByEmail(String email);

}
