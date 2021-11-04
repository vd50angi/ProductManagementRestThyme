package com.cogent.productmanagementrestthyme.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cogent.productmanagementrestthyme.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

	
	
	
	/*	@Query
	(value="select s from Student s where s.name=:name")
	
	public Student getStudentByName(@Param("name")String name);
	//public Student findByName(@Param("name") String n);
*/
}	
	
	


