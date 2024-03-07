package com.javarest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController 
{
@Autowired
private IProductService productService;
//mapping the getProduct() method to /product
@GetMapping(value = "/product")
	public List<Product> getProduct() 
	{
		//finds all the products
		List<Product> products = productService.findAll();
		//returns the product list
		return products;
	}

	@GetMapping(value="/home")
	public String getHome() {
		
		return "home Page";
	} 
	
	@PostMapping(value="/addproduct")
	public String  addProduct(@RequestBody Product product) {
		String str = productService.AddProduct(product);
		return "One product added " +product.getId();
	}
	
	@PutMapping("/product/{id}")
	  public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
	    List<Product> productData = productService.findAll();
	    Product product1 = null;
	    for(Product prod : productData) {
	    	
	    	if(prod.getId() == id) {
	    		
	    		prod.setBatchno(product.getBatchno());
	    		prod.setNoofproduct(product.getNoofproduct());
	    		prod.setPname(product.getPname());
	    		prod.setPrice(product.getPrice());
	    		product1=prod;
	    	}
	    }
	    return product1;
	}
	
	@DeleteMapping("/product/{id}")
	  public String deleteProduct(@PathVariable("id") long id) {
	    	List<Product> productData = productService.findAll();
	 	    for(Product prod : productData) {
	 	    	
	 	    	if(prod.getId() == id) {
	 	    		
	 	    		productData.remove(prod);
	 	    		break;
	 	    	}
	 	    }
	    	
	    return "Delete product Id :"+ id;
	  }
	
	
	
}
