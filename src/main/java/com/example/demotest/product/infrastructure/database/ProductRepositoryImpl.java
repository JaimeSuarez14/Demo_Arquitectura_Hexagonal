package com.example.demotest.product.infrastructure.database;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demotest.product.domain.entity.Product;
import com.example.demotest.product.domain.exception.ProductNotFoundException;
import com.example.demotest.product.domain.port.ProductRepository;
import com.example.demotest.product.infrastructure.database.entity.ProductEntity;
import com.example.demotest.product.infrastructure.database.mapper.ProductEntityMapper;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	private final JpaProductRepository jpaProductRepository;
	private final ProductEntityMapper productEntityMapper;

	public ProductRepositoryImpl(JpaProductRepository jpaProductRepository, ProductEntityMapper productEntityMapper) {
		this.jpaProductRepository = jpaProductRepository;
		this.productEntityMapper = productEntityMapper;
	}

	@Override
	public void upsert(Product product) {
		ProductEntity entity = productEntityMapper.mapToProductEntity(product);
		this.jpaProductRepository.save(entity);

	}

	@Override
	public Optional<Product> findById(Long id) {
		ProductEntity entity =  jpaProductRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));
		Product product =  productEntityMapper.mapToProduct(entity);
		return Optional.of(product);
	}

	@Override
	public List<Product> findAll() {
		 return this.jpaProductRepository.findAll().stream().map(productEntityMapper::mapToProduct).toList();
	}

	@Override
	public void deleteById(Long id) {
		this.jpaProductRepository.deleteById(id);
	}

}
