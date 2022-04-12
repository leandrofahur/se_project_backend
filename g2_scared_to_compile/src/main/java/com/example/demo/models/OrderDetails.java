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
@Table (name = "orderDetails")

public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERDETAILS_SEQ_GENERATOR")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userID", nullable = false)
	private User userID;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "paymentID", nullable = false)
	private UserPayment paymentID;
	
	@Column(name = "total")
	private double total;
	
	
	public OrderDetails() {}
	
	public OrderDetails(User userID, UserPayment paymentID, double total) {
		super();
		this.userID = userID;
		this.paymentID =paymentID;
		this.total = total;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getUserID() {
		return userID;
	}


	public void setUserID(User userID) {
		this.userID = userID;
	}


	public UserPayment getPaymentID() {
		return paymentID;
	}


	public void setPaymentID(UserPayment paymentID) {
		this.paymentID = paymentID;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	




}
