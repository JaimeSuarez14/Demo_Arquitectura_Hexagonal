package com.example.demotest.product.application.query.getAlllProduct;

import java.util.List;

import com.example.demotest.product.domain.Product;

public class GetAllProductResponse {
  private List<Product> products;

  public GetAllProductResponse(List<Product> products) {
    this.products = products;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

}
