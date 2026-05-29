package com.example.demotest.product.application.query.getById;

import org.springframework.stereotype.Service;

import com.example.demotest.common.mediator.RequestHandler;
import com.example.demotest.product.domain.Product;
import com.example.demotest.product.domain.ProductRespository;

@Service
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

	private ProductRespository productRespository;

	public GetProductByIdHandler(ProductRespository productRespository) {
		this.productRespository = productRespository;
	}

	@Override
	public GetProductByIdResponse handle(GetProductByIdRequest request) {
		Product product = productRespository.findById(request.getId())
				.orElseThrow(() -> new IllegalArgumentException("Product Not Found"));
		return new GetProductByIdResponse(product);
	}

	@Override
	public Class<GetProductByIdRequest> getRequestType() {
		return GetProductByIdRequest.class;
	}

}
