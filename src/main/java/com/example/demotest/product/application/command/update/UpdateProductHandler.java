package com.example.demotest.product.application.command.update;

import org.springframework.stereotype.Service;

import com.example.demotest.common.mediator.RequestHandler;
import com.example.demotest.product.domain.entity.Product;
import com.example.demotest.product.domain.port.ProductRepository;

@Service
public class UpdateProductHandler implements RequestHandler<UpdateProductRequest, Void>{

  private ProductRepository productRespository;
	
	public UpdateProductHandler(ProductRepository productRespository) {
		this.productRespository = productRespository;
	}

  @Override
  public Void handle(UpdateProductRequest request) {
    Product product = new Product(request.getId(), request.getName(), request.getDescription(), request.getPrice(), request.getImage());	
    productRespository.upsert(product);	
    return null;
  }

  @Override
  public Class<UpdateProductRequest> getRequestType() {
    return UpdateProductRequest.class;
  }

}
