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
import com.hcl.retailapp.service.ProductService;

@RestController
public class ProductController {

	int productCount = 0;
	@Autowired
	ProductService productservice;

	@PostMapping(value = "/product/selectproduct/{pId}")
	public ResponseEntity selectProduct(@PathVariable int pId) {

		List<Product> productlist = productservice.productDetails(pId);
		if (productlist.isEmpty()) {
			return new ResponseEntity<String>("No Products in the list", HttpStatus.OK);

		} else {
			productCount++;
			int proCount = productCount;
			System.out.println(pId);
			System.out.println(proCount);
			productservice.incrementCount(proCount, pId);
			return new ResponseEntity<List<Product>>(productlist, HttpStatus.OK);
		}
	}
}
