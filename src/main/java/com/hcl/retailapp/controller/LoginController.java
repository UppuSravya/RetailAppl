package com.hcl.retailapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailapp.entity.Category;
import com.hcl.retailapp.entity.Customer;
import com.hcl.retailapp.service.CategoryService;
import com.hcl.retailapp.service.LoginService;
import com.hcl.retailapp.service.RegistrationService;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	@Autowired
	RegistrationService registrationservice;
	
	@Autowired
	LoginService loginservice;
	
	@Autowired
	CategoryService categoryservice;
	

	@PostMapping(value="/check")
	public ResponseEntity getCustomerByNameAndPassword(@RequestBody Customer customer,Category category){
		
		String userName= customer.getUserName();
		String password= customer.getPassword();
		List<Customer> resCustomer = loginservice.checkCustomer(userName,password);
		
		
		if(resCustomer.isEmpty()){
			return new ResponseEntity<String>("Invalid Username or password", HttpStatus.OK);

		} else if(resCustomer.get(0).getUserName().equals(customer.getUserName())&& resCustomer.get(0).getPassword().equals(customer.getPassword())){
			List<Category> resCategory = categoryservice.getCategories();
		/*	LoginResponse loginResponse = new LoginResponse();
			loginResponse.setUserName(resCustomer.get(0).getUserName());
			loginResponse.setCategory(resCategory);*/
			return new ResponseEntity<List<Category>>(resCategory, HttpStatus.OK);

		}  	else {
			return new ResponseEntity<String>("Password Mismatch", HttpStatus.OK);

			}
	}
	
}

