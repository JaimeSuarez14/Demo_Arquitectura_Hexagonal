package com.example.demotest.product.application.command.create;

import org.springframework.stereotype.Service;

import com.example.demotest.common.mediator.RequestHandler;
import com.example.demotest.product.domain.Product;
import com.example.demotest.product.domain.ProductRespository;

@Service
public class ProductCreateHandler implements RequestHandler<ProductCreateRequest, Void>{

	private ProductRespository productRespository;
	
	public ProductCreateHandler(ProductRespository productRespository) {
		this.productRespository = productRespository;
	}

	@Override
	public Void handle(ProductCreateRequest request) {
		Product product = new Product(null, request.getName(), request.getDescription(), request.getPrice(), request.getImage());		
		productRespository.upsert(product);
		return null;
	}

	@Override
	public Class<ProductCreateRequest> getRequestType() {
		return ProductCreateRequest.class;
	}

}
