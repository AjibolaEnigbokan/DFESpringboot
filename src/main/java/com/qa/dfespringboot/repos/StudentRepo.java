package com.qa.dfespringboot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.dfespringboot.entities.Customer;
import com.qa.dfespringboot.entities.Student;
// this requires the entity and the object type.

public interface StudentRepo extends JpaRepository<Student, Long> {

	List<Student> findStudentByFirstName(String firstName);

	List<Student> findStudentByLastName(String lastName); // custom search by last name

}
