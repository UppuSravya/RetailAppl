package com.hcl.retailapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailapp.entity.Category;
import com.hcl.retailapp.entity.Product;
import com.hcl.retailapp.repository.CategoryRepository;
import com.hcl.retailapp.repository.ProductRepository;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryrepository;
	
	@Autowired
	ProductRepository productrepository;
	
	
	public List<Category> getCategories() {
		return categoryrepository.findAll();
	}


	public List<Product> showproducts(int cId) {
		return productrepository.findAllByCategoryId(cId);
	}


	public void incrementCount(int catCount,int cId){
		categoryrepository.incrementCount(catCount,cId);
	}


	public List<?> getData() {
		return categoryrepository.getData();
	}
}
