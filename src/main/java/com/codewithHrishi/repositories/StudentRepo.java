package com.codewithHrishi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithHrishi.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	Optional<Student>findByUsername(String Username);
}
