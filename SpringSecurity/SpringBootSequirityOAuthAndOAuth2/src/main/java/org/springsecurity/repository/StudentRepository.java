package org.springsecurity.repository;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springsecurity.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Id> {

	Optional<Student> findById(String studentId);
 
	 Student findByUserName(String username);
	
}
