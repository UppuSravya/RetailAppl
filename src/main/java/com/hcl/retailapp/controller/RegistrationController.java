package com.hcl.retailapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailapp.entity.Customer;
import com.hcl.retailapp.service.RegistrationService;

@RestController
public class RegistrationController {
		
	@Autowired
	RegistrationService registerservice;
	
	@PostMapping(value="/register/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
		registerservice.registerCustomer(customer);
		return new ResponseEntity<String>("customer registered successfully", HttpStatus.CREATED);
	}
	
}
