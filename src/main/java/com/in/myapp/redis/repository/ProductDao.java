package com.in.myapp.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.in.myapp.redis.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private RedisTemplate redisTemplate;
	public static final String HASH_KEY = "Product";
	
	public Product save(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}
	
	public List<Product> findAll() {
		return redisTemplate.opsForHash().values(HASH_KEY);
	}
	
	public Product findByProductId(int id) {
		System.out.println("findByProductId DB call Invoked!!!");
		return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
//		 System.out.println(redisTemplate.opsForHash().get("myHash","key"));
//		 return new Product();

	}
	
	public String deleteByProductId(int id) {
		redisTemplate.opsForHash().delete(HASH_KEY, id);
		return "Product removed !!!";
	}
	
}
