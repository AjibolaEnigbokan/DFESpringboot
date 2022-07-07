package com.qa.dfespringboot.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//JpaRepository requires booth the Entity and the Datatype for the id column. This must be the object version e.g So long = Long and ,int = Integer

import com.qa.dfespringboot.entities.Customer;

@Repository 
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	
	//List<Customer> findCustomerByFirstName(String firstName);    // to implement further or what more things with ur API call custome quesries
	

}
