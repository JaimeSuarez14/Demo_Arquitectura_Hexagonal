package com.example.demotest.product.infrastructure.api.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class ProductDto {
	private Long id;
	@NotBlank(message = "El nombre no puede estar en blanco")
	private String name;
	@Length(min = 10, max = 255, message = "Descripcion debe estar entre 10 y 255 palabras")
	private String description;
	@DecimalMin(value = "0.01", inclusive = false )
	@DecimalMax(value = "999.99", inclusive = false )
	private double price;
	private String image;
	
	public ProductDto(){}
	
	public ProductDto(Long id, String name, String description, double price, String image) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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
	
	
	
}
