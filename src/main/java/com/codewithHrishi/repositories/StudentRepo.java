package com.codewithHrishi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithHrishi.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
