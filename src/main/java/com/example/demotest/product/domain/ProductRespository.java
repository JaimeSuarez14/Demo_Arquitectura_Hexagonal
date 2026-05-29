package com.example.demotest.product.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRespository {
	void upsert(Product product);
	Optional<Product> findById(Long id);
	List<Product> findAll();
	void deleteById(Long id);
}
