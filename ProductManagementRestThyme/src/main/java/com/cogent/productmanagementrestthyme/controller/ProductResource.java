package com.cogent.productmanagementrestthyme.controller;

import java.net.URI;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cogent.productmanagementrestthyme.repository.ProductRepository;
import com.cogent.productmanagementrestthyme.exception.ResourceNotFoundException;
import com.cogent.productmanagementrestthyme.model.Product;


//{"studentcode":1001,"studentname":"Angie","score":90}


//@Controller
@RestController

public class ProductResource {
	/*@GetMapping
	 * @PostMapping
	 * @PutMapping
	 * @DeleteMapping*/
	@Autowired
	ProductRepository productRepository;
	private Object product1;

@GetMapping("/")	
	public List<Product> retrieveAllProducts(){
		List<Product> prodList = productRepository.findAll();
		System.out.println("List is "+prodList);
		prodList.stream().forEach(System.out::println);
		System.out.println("Coming here");
		return prodList;	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Optional<Product>> retriveProduct(@PathVariable int id)throws ResourceNotFoundException{
		Optional<Product> p1 = productRepository.findById(id);
		return ResponseEntity.ok().body(p1);
	}
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		//productRepository.deleteData(id);
		productRepository.deleteById(id);
	}	//@PostMapping("/product")
	
	@PostMapping("/product")
	public ResponseEntity<Object>
     createProduct(@RequestBody Product product) {
		productRepository.save(product);
    // http://Localhost:8080/product/11		
    	 URI location =
    	 ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(product.getProductCode()).toUri();
////it is changing the uri from current location to location http://localhost:8080/product/11
		return ResponseEntity.created(location).build();

}
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateStudent(@RequestBody Product product, @PathVariable int id)
	throws ResourceNotFoundException{
	       Product product1 = productRepository.findById(id)
	    	        .orElseThrow(() ->
	    	        new ResourceNotFoundException("Student not found for this id :: " + id));
		product1.setProductCode(id);
		product1.setProductName(product.getProductName());
		product1.setTotalPrice(product.getTotalPrice());
		product1.setQuantity(product.getQuantity());

		return ResponseEntity.ok(product1);
	}	

}	
	
	
