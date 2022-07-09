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
import com.qa.dfespringboot.repos.CustomerRepo;

@Service
public class CustomerService {
	
	private CustomerRepo repo;
	
	public CustomerService(CustomerRepo repo){
		
		this.repo = repo;
	}

	
	public List<Customer> readByFirstName(String firstName){     // ReadByFirstName this is a custom search
	 return this.repo.findCustomerByFirstName(firstName);
	
	}

	// (GET - READ)
	// ReadAll

	public List<Customer> readAll() {

		return this.repo.findAll();
	}

//ReadByID will be used in DataBase but cos we are using List Array we will use index.

	public Customer readById(long id) {

		return this.repo.findById(id).get();
	}

	// Post -CREATE

	public Customer create(Customer customer) {
		return this.repo.saveAndFlush(customer);
	}

	// PUT -UPDATE

	public Customer update(long id,Customer customer){
		
		// 1-we need toget existing entry
		Customer existing = this.repo.findById(id).get();
		//2- Change the existing entry , using our new object above
		
		existing.setFirstName(customer.getFirstName());
		existing.setLastName(customer.getLastName());
		existing.setEmail(customer.getEmail());
		//3save the entry back into the database
		return this.repo.saveAndFlush(existing);

	

	}

	// DELETE - DELETE

	public boolean delete(long id) {

		 this.repo.deleteById(id);
		return  !this.repo.existsById(id); // existsById sould be false but must be flipped or invert to make it true.
	}

}
