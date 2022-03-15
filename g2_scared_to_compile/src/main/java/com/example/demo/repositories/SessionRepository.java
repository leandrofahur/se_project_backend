package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	Optional<Session> findById(long id);
}
