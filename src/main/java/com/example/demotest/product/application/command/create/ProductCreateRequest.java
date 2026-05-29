package com.example.demotest.product.application.command.create;

import com.example.demotest.common.mediator.Request;

public class ProductCreateRequest implements Request<Void>{
	private String name;
	private String description;
	private double price;
	private String image;
	
	public ProductCreateRequest() {}
	
	public ProductCreateRequest(String name, String description, double price, String image) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
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
	
	public ProductCreateRequest(Builder builder) {
		this.name = builder.name;
		this.description = builder.description;
		this.price = builder.price;
		this.image = builder.image;
	}
	
	public static class Builder{
		private String name;
		private String description;
		private double price;
		private String image;
		
		public Builder() {}
		
		public Builder name(String name) {
            this.name = name;
            return this;
        }
		
		public Builder description(String description) {
            this.description = description;
            return this;
        }
		public Builder price(double price) {
            this.price = price;
            return this;
        }
		
		public Builder image(String image) {
            this.image = image;
            return this;
        }
		
		public ProductCreateRequest build() {
            return new ProductCreateRequest(this);
        }
	}
	
}
