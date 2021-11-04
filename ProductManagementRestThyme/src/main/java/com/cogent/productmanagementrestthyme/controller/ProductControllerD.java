package com.cogent.productmanagementrestthyme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cogent.productmanagementrestthyme.service.ProductService;
import com.cogent.productmanagementrestthyme.exception.ResourceNotFoundException;
import com.cogent.productmanagementrestthyme.model.Product;
import antlr.collections.List;

@Controller

public class ProductControllerD {
	
	
	@Autowired
	ProductService productService;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listProduct", productService.findAllProducts());
		return "index";
	}
	@GetMapping("/showNewProductForm")
	public String showNewProduce(Model model) {
		System.out.println("Coming here");
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product")Product product) {
		productService.insertProduct(product);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id")int id,Model model) throws ResourceNotFoundException {
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "update_product";
	}
	 @GetMapping("/deleteProduct/{id}")
	    public String deleteEmployee(@PathVariable(value = "id") int id) {

	        
	        productService.deleteData(id);
	        return "redirect:/";
	    }
}
	






























//**************************************************************
	/*ProductRepository productRepository;
	@GetMapping("/")
	public List<Product> getAllProduct(Model model)
	{
		List<Product> prdlist=productRepository.findAll();
		model.addAttribute("listdata",prdlist);
		return prdlist;
	}
	@GetMapping("/showForm")
	public String display(Model m)
	{
	Product p=new Product();
	m.addAttribute("prd",p);
	return "new_product";
		
	}
	//@PostMapping("/addDetails")
	@PostMapping("/saveProduct")
    public String saveProduct
    (@ModelAttribute("prd") Product prd) {
        // save employee to database
        productRepository.save(prd);
        //return "redirect:/";//It works like a forward
        // it will forward the request to request for /
        return "welcome";*/
   
	
	
	
	
	
	

