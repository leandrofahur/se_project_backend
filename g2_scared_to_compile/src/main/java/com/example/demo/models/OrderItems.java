package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderItems")

public class OrderItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERITEMS_SEQ_GENERATOR")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	private Product productID;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "order_id", nullable = false)
	private Product orderID;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	public OrderItems() {}
	
	public OrderItems(Product productID, Product orderID, int quantity) {
		this.productID = productID;
		this.orderID = orderID;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public Product getOrderID() {
		return orderID;
	}

	public void setOrderID(Product orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
