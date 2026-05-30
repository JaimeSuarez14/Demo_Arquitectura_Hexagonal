package com.example.demotest.product.application.command.update;

import com.example.demotest.common.mediator.Request;

public class UpdateProductRequest implements Request<Void> {
  private Long id;
  private String name;
  private String description;
  private double price;
  private String image;

  public UpdateProductRequest() {
  }

  public UpdateProductRequest(Long id, String name, String description, double price, String image) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.image = image;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  
}
