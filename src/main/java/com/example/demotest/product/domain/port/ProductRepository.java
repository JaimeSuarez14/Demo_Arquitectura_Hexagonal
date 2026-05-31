package com.example.demotest.product.domain.port;

import java.util.List;
import java.util.Optional;

import com.example.demotest.product.domain.entity.Product;

public interface ProductRepository {
	void upsert(Product product);
	Optional<Product> findById(Long id);
	List<Product> findAll();
	void deleteById(Long id);
}
