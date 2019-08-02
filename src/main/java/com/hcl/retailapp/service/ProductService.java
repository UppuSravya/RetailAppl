package com.hcl.retailapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.retailapp.entity.Product;

import com.hcl.retailapp.repository.ProductRepository;


@Service
public class ProductService {

	
	@Autowired
	ProductRepository productrepository;
	

	public List<Product> productDetails(int pId) {
		return productrepository.findAllByProductId(pId);
	}



	public void incrementCount(int proCount, int pId) {
		productrepository.incrementCount(proCount,pId);
	}


	public List<?> getProductData() {
		return productrepository.getProductData();
	}

}
