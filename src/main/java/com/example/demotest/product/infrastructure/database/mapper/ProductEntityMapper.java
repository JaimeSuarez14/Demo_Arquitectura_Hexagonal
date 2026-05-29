package com.example.demotest.product.infrastructure.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.example.demotest.product.domain.Product;
import com.example.demotest.product.infrastructure.database.entity.ProductEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductEntityMapper {
    ProductEntity mapToProductEntity(Product product);
    Product mapToProduct(ProductEntity productEntity);

}
