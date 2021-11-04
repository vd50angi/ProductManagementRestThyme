package com.cogent.productmanagementrestthyme.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.productmanagementrestthyme.exception.ResourceNotFoundException;
import com.cogent.productmanagementrestthyme.model.Product;
import com.cogent.productmanagementrestthyme.repository.ProductRepository;

@Service

public class ProductService {

	@Autowired
	
	ProductRepository productRepository;
	
	public void insertProduct(Product product) {
		productRepository.save(product);
	}
	
	public Product findById(int id) throws ResourceNotFoundException {
		return productRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("null"));	
	}
		
	public void deleteData(int product_id) {
			productRepository.deleteById(product_id);
		}
	
	public void updateData(int product_id, Product product) {
		Optional<Product> prod = productRepository.findById(product_id);
		if(prod.isPresent()) {
			Product p1 = prod.get();
			p1.setProductName(product.getProductName());
			p1.setQuantity(product.getQuantity());
			p1.setTotalPrice(product.getTotalPrice());
            productRepository.save(product);
		}
	}
	
	     public List<Product> findAllProducts(){
		  return  productRepository.findAll();
	}
	

}
