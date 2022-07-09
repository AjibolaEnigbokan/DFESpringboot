package com.qa.dfespringboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringboot.entities.Customer;
import com.qa.dfespringboot.entities.Student;
import com.qa.dfespringboot.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	// GET- READ (GET Request)
	// @GetMapping("/student") // localhost :8080/student //(GET - READ)

	// GET- READ- ReadAll

	@GetMapping("/readAll")
	public List<Student> readAll() {
		return this.service.readAll();
	}

	// ReadByID

	@GetMapping("/readById/{id}")
	public Student readById(@PathVariable int id) {

		return this.service.readById(id);
	}

	@GetMapping("/readByFirstName/{firstName}") // ReadByFirstName this is a custom search
	public List<Student> readByFirstName(@PathVariable String firstName) {

		return this.service.readByFirstName(firstName);

	}

	@GetMapping("/readByLastName/{lastName}") // ReadByLastName this is a custom search
	public List<Student> readByLastName(@PathVariable String lastName) {

		return this.service.readByLastName(lastName);
	}

	// POST- create

	@PostMapping("/create") // localhost:8080/student/create
	public Student create(@RequestBody Student student) {

		return this.service.create(student);

	}

	// PUT Update

	@PutMapping("/update/{id}")
	public Student update(@PathVariable int id, @RequestBody Student student) {

		// returns the updated student
		return this.service.update(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {

		return this.service.delete(id);
	}

}
