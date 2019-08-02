package com.hcl.retailapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hcl.retailapp.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByCategoryId(int cId);

	List<Product> findAll();

	List<Product> findAllByProductId(int pId);
	
	@Scheduled
	@Transactional
	@Modifying
	@Query(value="update product set product_count= :productCount where product_id= :cId", nativeQuery = true)
	void incrementCount(@Param("productCount") int productCount, @Param("cId") int cId);
	

	@Query("select p.productName ,p.productCount from Product p")
	public List<?> getProductData();	
	
}
