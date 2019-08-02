package com.hcl.retailapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailapp.entity.Category;
import com.hcl.retailapp.entity.Product;
import com.hcl.retailapp.service.CategoryService;
import com.hcl.retailapp.service.ProductService;

@RestController
public class DataAnalyticsController {
	
	@Autowired
	CategoryService categoryservice;
	
	@Autowired
	ProductService productservice;
	

	
	@GetMapping(value = "/analytics/categories")
	public ResponseEntity getAnalytics() {
		
		List<?> categorylist = categoryservice.getData();
		
		return new ResponseEntity<List<?>>(categorylist, HttpStatus.OK);

	}
	

	@GetMapping(value = "/analytics/products")
	public ResponseEntity getAnalyticss() {
		
		List<?> productlist = productservice.getProductData();
		
		return new ResponseEntity<List<?>>(productlist, HttpStatus.OK);

	}
	
	
}
	

