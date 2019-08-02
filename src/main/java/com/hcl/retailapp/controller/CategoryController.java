package com.hcl.retailapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailapp.entity.Category;
import com.hcl.retailapp.entity.Product;
import com.hcl.retailapp.service.CategoryService;

@RestController
public class CategoryController {

	int categoryCount = 0;
	@Autowired
	CategoryService categoryservice;

	@PostMapping(value = "/category/selectcategory/{cId}")
	public ResponseEntity selectCategory(@PathVariable int cId) {

		List<Product> productlist = categoryservice.showproducts(cId);
		if (productlist.isEmpty()) {
			return new ResponseEntity<String>("No Products in the list", HttpStatus.OK);

		} else {
			categoryCount++;
			int catCount = categoryCount;
			System.out.println(cId);
			System.out.println(catCount);
			categoryservice.incrementCount(catCount, cId);
			return new ResponseEntity<List<Product>>(productlist, HttpStatus.OK);
		}
	}
}
