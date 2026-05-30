package com.example.demotest.product.infrastructure.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demotest.common.mediator.Mediator;
import com.example.demotest.product.application.command.create.ProductCreateRequest;
import com.example.demotest.product.application.command.delete.DeleteProductRequest;
import com.example.demotest.product.application.command.update.UpdateProductRequest;
import com.example.demotest.product.application.query.getAlllProduct.GetAllProductRequest;
import com.example.demotest.product.application.query.getAlllProduct.GetAllProductResponse;
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
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(name = "pageSize",required = false) String pageSize) {
		GetAllProductResponse response =  mediator.dispatch(new GetAllProductRequest());
		List<ProductDto> lista =  response.getProducts().stream().map(e -> productMapper.mapToProductDto(e)).collect(Collectors.toList());
		return ResponseEntity.ok(lista);
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
	@PutMapping
	public ResponseEntity<Void> updateProduct(@RequestBody  ProductDto product) {
		UpdateProductRequest update =  this.productMapper.mapToUpdateProductRequest(product);
		this.mediator.dispatch(update);
		return ResponseEntity.ok().build();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") Long id) {
		mediator.dispatch(new DeleteProductRequest(id));
		return ResponseEntity.noContent().build();
	}

}
