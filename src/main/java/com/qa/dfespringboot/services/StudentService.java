package com.qa.dfespringboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.dfespringboot.entities.Customer;
import com.qa.dfespringboot.entities.Student;
import com.qa.dfespringboot.repos.StudentRepo;

@Service
public class StudentService {

	// here we will be using our database instead of Array list

	private StudentRepo repo;

	public StudentService(StudentRepo repo) {

		this.repo = repo;

	}

	// GET- READ
	// @GetMapping("/student") // localhost :8080/student //(GET - READ)

	// GET- READ- ReadAll

	public List<Student> readAll() {

		return this.repo.findAll();
	}

	// ReadByID

	public Student readById(long id) {

		return this.repo.findById(id).get();
	}

	// POST- create

	public Student create(Student student) {

		return this.repo.saveAndFlush(student);

	}

	// ReadByFirstName

	public List<Student> readByFirstName(String firstName) { // ReadByFirstName this is a custom search
		return this.repo.findStudentByFirstName(firstName);

	}

	public List<Student> readByLastName(String lastName) { // ReadByLastName this is a custom search
		return this.repo.findStudentByLastName(lastName);

	}

	// PUT Update

	public Student update(long id, Student student) {

		Student existingStudent = this.repo.findById(id).get(); // updating the exitingStudent entry

		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setAddress(student.getAddress());

		// saving the entry into database
		return this.repo.saveAndFlush(existingStudent);

	}

	public boolean delete(long id) {

		this.repo.deleteById(id);

		return !this.repo.existsById(id); // this must be flap to make sure it return true
	}

}
