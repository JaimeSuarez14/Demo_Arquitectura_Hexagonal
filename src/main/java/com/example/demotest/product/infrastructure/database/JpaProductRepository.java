package com.example.demotest.product.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demotest.product.infrastructure.database.entity.ProductEntity;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

}
