package com.example.demotest.product.application.query.getAlllProduct;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demotest.common.mediator.RequestHandler;
import com.example.demotest.product.domain.Product;
import com.example.demotest.product.domain.ProductRepository;

@Service
public class GetAllProductHandler implements RequestHandler<GetAllProductRequest, GetAllProductResponse> {

  private ProductRepository productRepository;

  public GetAllProductHandler(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public GetAllProductResponse handle(GetAllProductRequest request) {
    List<Product> all = productRepository.findAll();
    return new GetAllProductResponse(all);
  }

  @Override
  public Class<GetAllProductRequest> getRequestType() {
    return GetAllProductRequest.class;
  }

}
