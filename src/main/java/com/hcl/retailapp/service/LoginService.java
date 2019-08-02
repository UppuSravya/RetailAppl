package com.hcl.retailapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailapp.entity.Customer;
import com.hcl.retailapp.repository.RegistrationRepository;


@Service
public class LoginService {
	
	@Autowired
	RegistrationRepository registrationrepository;
	
	public List<Customer> checkCustomer(String userName,String password){
		
		return registrationrepository.findByUserNameAndPassword(userName,password);	
	}
}






