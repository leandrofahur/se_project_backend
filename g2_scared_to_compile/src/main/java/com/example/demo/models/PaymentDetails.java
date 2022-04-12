package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@Table (name = "paymentDetails")

public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENTDETAILS_SEQ_GENERATOR")
	private long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "orderId")
	private OrderDetails orderID;
	
	/*
	@OneToOne
	@JoinColumn(name = "amount")			// ask
	private double amount;
	*/
	@Column(name = "total")
	private double total;
	/*
	@Column(name = "payment_id")		// ask
	private double payment_id;
	*/
	
	public PaymentDetails() {}
	
	public PaymentDetails(OrderDetails orderID, double total) {
		this.orderID = orderID;
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderDetails getOrderID() {
		return orderID;
	}

	public void setOrderID(OrderDetails orderID) {
		this.orderID = orderID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
}
