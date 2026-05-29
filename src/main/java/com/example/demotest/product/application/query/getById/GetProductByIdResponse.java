package com.example.demotest.product.application.query.getById;

import com.example.demotest.product.domain.Product;

public class GetProductByIdResponse {
  private Product product;

  public GetProductByIdResponse(Product product) {
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  
}
