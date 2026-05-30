package com.example.demotest.product.application.command.delete;

import com.example.demotest.common.mediator.Request;

public class DeleteProductRequest implements Request<Void> {
  private Long id;

  public DeleteProductRequest(Long id) {
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
