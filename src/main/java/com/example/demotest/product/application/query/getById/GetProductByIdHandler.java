package com.example.demotest.product.application.query.getById;

import org.springframework.stereotype.Service;

import com.example.demotest.common.mediator.RequestHandler;
import com.example.demotest.product.domain.entity.Product;
import com.example.demotest.product.domain.exception.ProductNotFoundException;
import com.example.demotest.product.domain.port.ProductRepository;

@Service
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

	private ProductRepository productRespository;

	public GetProductByIdHandler(ProductRepository productRespository) {
		this.productRespository = productRespository;
	}

	@Override
	public GetProductByIdResponse handle(GetProductByIdRequest request) {
		Product product = productRespository.findById(request.getId())
				.orElseThrow(() -> new ProductNotFoundException("Producto no encontrado con ese Id : " + request.getId()));
		return new GetProductByIdResponse(product);
	}

	@Override
	public Class<GetProductByIdRequest> getRequestType() {
		return GetProductByIdRequest.class;
	}

}
