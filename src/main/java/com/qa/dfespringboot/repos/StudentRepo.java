package com.qa.dfespringboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.dfespringboot.entities.Student;
// this requires the entity and the object type.

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	
	

}
