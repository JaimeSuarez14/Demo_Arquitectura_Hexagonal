package com.example.demotest.product.infrastructure.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.example.demotest.product.application.command.create.ProductCreateRequest;
import com.example.demotest.product.application.command.update.UpdateProductRequest;
import com.example.demotest.product.domain.entity.Product;
import com.example.demotest.product.infrastructure.api.dtos.ProductDto;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
	
	ProductCreateRequest mapToProductCreateRequest(ProductDto dto);
	UpdateProductRequest mapToUpdateProductRequest(ProductDto dto);
	ProductDto mapToProductDto(Product product);
}
