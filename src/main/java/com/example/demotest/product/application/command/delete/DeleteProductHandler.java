package com.example.demotest.product.application.command.delete;

import org.springframework.stereotype.Service;

import com.example.demotest.common.mediator.RequestHandler;
import com.example.demotest.product.domain.port.ProductRepository;

@Service
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void >{

  private ProductRepository productRespository;
	
	public DeleteProductHandler(ProductRepository productRespository) {
		this.productRespository = productRespository;
	}


  @Override
  public Void handle(DeleteProductRequest request) {
    productRespository.deleteById(request.getId());
    return null;
  }

  @Override
  public Class<DeleteProductRequest> getRequestType() {
    return DeleteProductRequest.class;
  }

}
