package com.example.demotest.product.infrastructure.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demotest.common.mediator.Mediator;
import com.example.demotest.product.application.command.create.ProductCreateRequest;
import com.example.demotest.product.application.query.getById.GetProductByIdRequest;
import com.example.demotest.product.application.query.getById.GetProductByIdResponse;
import com.example.demotest.product.domain.Product;
import com.example.demotest.product.infrastructure.api.dtos.ProductDto;
import com.example.demotest.product.infrastructure.api.mapper.ProductMapper;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController implements ProductApi{
	
	private final Mediator mediator;
	private final ProductMapper productMapper;

	public ProductController(Mediator mediator, ProductMapper productMapper) {
		this.mediator = mediator;
		this.productMapper = productMapper;
	}

	@Override
	public ResponseEntity<List<ProductDto>> getAllProducts(String pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Long id) {
	 	GetProductByIdResponse getProductByIdResponse = this.mediator.dispatch(new GetProductByIdRequest(id));
		Product prod = getProductByIdResponse.getProduct();
		ProductDto dto = productMapper.mapToProductDto(prod);
		return ResponseEntity.ok(dto);
	}

	@Override
	@PostMapping
	public ResponseEntity<Void> saveProduct(@RequestBody ProductDto productDto) {
		ProductCreateRequest createProduct =  this.productMapper.mapToProductCreateRequest(productDto);
		this.mediator.dispatch(createProduct);
		return ResponseEntity.created(URI.create("/api/v1/products/".concat(productDto.getId().toString()))).build();
	}

	@Override
	public ResponseEntity<ProductDto> updateProduct(ProductDto product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
