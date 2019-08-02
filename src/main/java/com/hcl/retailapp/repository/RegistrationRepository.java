package com.hcl.retailapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.retailapp.entity.Customer;

@Repository
public interface RegistrationRepository extends JpaRepository<Customer, String>{

	List<Customer> findByUserNameAndPassword(String userName, String password);

	/*List<Employee> findByFirstNameContainsAllIgnoreCaseOrderByFirstNameDesc(String firstName);
	
	@Query("select e.age , count(e) as count from Employee e group by e.age")
	List<?> getAnalytics();
	
	@Query("select e.age from Employee e WHERE e.firstName = :firstName and e.lastName = :lastName")
	List<?> getAgeByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query(value="select * from employee e WHERE e.first_name = :firstName and e.last_name = :lastName", nativeQuery = true)
	List<Employee> getAgeByNameNative(@Param("firstName") String firstName, @Param("lastName") String lastName);
*/

}
