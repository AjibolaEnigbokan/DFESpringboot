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
import com.qa.dfespringboot.services.CustomerService;


// Handle incoming HTTP requests and send responses
//uses JSON data
@RestController
@RequestMapping("/customer") // add prefix to the urls
public class CustomerController {
	
	private CustomerService service;
	
	// Dependency Injection
	
	public CustomerController(CustomerService service) { // make a constructor of the CustomerController and pass it CustomerService class of service as the input		
		this.service = service;
	}
	

	//(GET - READ)
	@GetMapping("/readAll") // localhost :8080/customer  
	public List<Customer> readAll(){

		return this.service.readAll();
	}
	
	
	@GetMapping("/readById/{id}")                               // id must match in the method.
	public Customer readById(@PathVariable long id) {
		
		return this.service.readById(id);
	}
	
	
	
	
	// Post -CREATE
	@PostMapping("/create") 								// localhost:8080/customer/create
	public Customer create(@RequestBody Customer customer) {
		// returns the latest entry added to the list
		return this.service.create(customer); // gets the most recent entry of the arrayList

	}
	
	
	//ReadByID will be used in DataBase but cos we are using List Array we will use index.
	
	
	
	
	@DeleteMapping( "/delete/{id}")
	public boolean delete(@PathVariable long id ) {
		
		return this.service.delete(id);
	}
	
	//PUT -UPDATE
	
	@PutMapping( "/update/{id}")
	public Customer update(@PathVariable long id, @RequestBody Customer customer) {
	
		//add the updated customer
	return	this.service.update(id, customer);
		

		
	}
	

	

}
