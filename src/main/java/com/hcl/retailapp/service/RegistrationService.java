package com.hcl.retailapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailapp.entity.Customer;
import com.hcl.retailapp.repository.RegistrationRepository;


@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationrepository;

	public Customer registerCustomer(Customer customer){
		return registrationrepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return registrationrepository.findAll();
		}
	}

	
	


























//here the save method is just declaration which is overriden in repository,
		//that is being implemented from JPA Repository--->Repositroy 