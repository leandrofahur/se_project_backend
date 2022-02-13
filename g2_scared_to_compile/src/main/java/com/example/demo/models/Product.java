package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private Float price;
	
	@Column(name="SKU")
	private String SKU;

	// TODO: Add category_id | inventory_id | discount_id | image_id and their proper relationships.
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	// TODO: Remember to re-generate with the new attributes on-hold: 
	public Product(String name, String description, Float price, String sKU) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		SKU = sKU;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}
}
