package com.rsaraiva.labs.springular.model;

public class Product {

	private Integer id;
	
	private String description;
	
	public Product() {
	}
	
	public Product(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
