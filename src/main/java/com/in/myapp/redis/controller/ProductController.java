package com.in.myapp.redis.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.myapp.redis.entity.Product;
import com.in.myapp.redis.repository.ProductDao;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductController{
	
	@Autowired
	private ProductDao productDao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	@GetMapping("/{id}")
	@Cacheable(key="#id", value="Product", unless = "#result.price > 300") //unless parameter doesn't cache the data if condition is true
	public Product findByProductId(@PathVariable int id) {
		return productDao.findByProductId(id);
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(key="#id", value="Product")
	public String removeAProductId(@PathVariable int id) {
		return productDao.deleteByProductId(id);
	}
	

}
