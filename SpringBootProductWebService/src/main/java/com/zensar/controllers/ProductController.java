package com.zensar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Product;
/**
 * @author Dipankar Chakraborty
 * @creation_date 12th Oct 2019 03:45PM
 * @modification_date 12th Oct 2019 03:45PM
 * @version 1.0
 * @copyright Zensar Technologies. All rights reserved
 * @description It is a Restful WebService Entity.
 */
import com.zensar.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.findAllProducts();

	}
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int productId) {
		return productService.findProductId(productId);
	}
	@PostMapping("/products/add")
	public String add(@RequestBody Product product) {
		productService.addProduct(product);
		return "new product: "+product.getProductId()+" is added";
	}
	@PostMapping("/products/addproduct")
	public String addProduct(@RequestParam("id")int productId,@RequestParam("name") String name,@RequestParam("brand") String brand,@RequestParam("price") float price) {
		Product product = new Product(productId,name,brand,price);
		productService.addProduct(product);
		return "new product: "+product.getProductId()+" is added";
	}
	@PutMapping("/products/update")
	public String update(@RequestBody Product product) {
		if(productService.findProductId(product.getProductId())!=null) {
		productService.updateProduct(product);
		return "Product is updated successfully" +product.getProductId();
		}
		else {
			return "Product not found";
		}
		
	}
	@DeleteMapping("/products/delete")
	public String delete(@RequestBody Product product) {
		if(productService.findProductId(product.getProductId())!=null) {
		productService.removeProduct(product);
		return "Product is deleted successfully" +product.getProductId();
		}
		else {
			return "Product not found";
		}
		
	}
}
