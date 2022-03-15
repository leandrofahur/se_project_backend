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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userAddresses")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERSADDRESSES_SEQ_GENERATOR")
	private long id;
	
	@Column(name = "addressLine1")
	private String addressLine1;
	
	@Column(name = "addressLine2")
	private String addressLine2;
	
	@Column(name = "city")
	private String city;

	@Column(name = "province")
	private String province;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
    private User user;
	
	public UserAddress() {}

	public UserAddress(String addressLine1, String addressLine2, String city, String province, String country,
			String postalCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
