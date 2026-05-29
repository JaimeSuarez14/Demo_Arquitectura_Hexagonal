package com.example.demotest.product.application.query.getById;

import com.example.demotest.common.mediator.Request;

public class GetProductByIdRequest implements Request<GetProductByIdResponse> {
  private Long id;

  public GetProductByIdRequest(Long id) {
    super();
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
}
