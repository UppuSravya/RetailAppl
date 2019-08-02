package com.hcl.retailapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.retailapp.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public  List<Category> findAll();
	
	
	@Scheduled
	@Transactional
	@Modifying
	@Query(value="update category set category_count= :categoryCount where category_id= :cId", nativeQuery = true)
	void incrementCount(@Param("categoryCount") int categoryCount, @Param("cId") int cId);




	@Query("select c.categoryType ,c.categoryCount from Category c")
	public List<?> getData();	
	
}
