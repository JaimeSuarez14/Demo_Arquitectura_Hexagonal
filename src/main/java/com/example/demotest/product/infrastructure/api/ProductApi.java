package com.example.demotest.product.infrastructure.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demotest.product.infrastructure.api.dtos.ProductDto;

public interface ProductApi {
	ResponseEntity<List<ProductDto>> getAllProducts(@RequestParam(required = false) String pageSize );
	ResponseEntity<ProductDto> getProductById(@PathVariable Long id );
	ResponseEntity<Void> saveProduct(@RequestBody ProductDto product);
	ResponseEntity<Void> updateProduct(@RequestBody ProductDto product );
	ResponseEntity<Void> deleteProduct(@PathVariable Long id );

}
