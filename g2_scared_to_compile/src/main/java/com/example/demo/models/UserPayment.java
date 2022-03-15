package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userPayments")
public class UserPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERPAYMENTS_SEQ_GENERATOR")
	private long id;
	
	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "expirationDate")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date expirationDate;
	
	@Column(name = "cvc")
	private String cvc;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
    private User user;
	
	public UserPayment() {}


	public UserPayment(String cardNumber, Date expirationDate, String cvc) {
		super();
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvc = cvc;
		
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public Date getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getCvc() {
		return cvc;
	}


	public void setCvc(String cvc) {
		this.cvc = cvc;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
