package com.example.demo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserPhones")
public class UserPhone {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long userPhoneId;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
//	@Column(name="userId")
//	private int userId; //datatype: maybe change to long?
	
	@Column(name="userPhoneId")
	private String userPhoneId;
	
	@Column(name="number")
	private String number;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	//@ManyToOne(mappedBy = "users", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	
	//@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "userId", nullable = false)
//	private Set<User> users = new HashSet<>();
	
	public UserPhone() {}

	//public UserPhone(long userPhoneId, String number, Set<User> users) {
//	public UserPhone(String number) {
//		super();
//		this.number = number;
//		//this.users = users;
//		
//		this.createdAt = new Date();
//		this.updatedAt = new Date();
//	}
	
	public UserPhone(String userPhoneId, String number) {
		super();
		this.userPhoneId = userPhoneId;
		this.number = number;
		
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

//	public long getUserPhoneId() {
//		return userPhoneId;
//	}
//
//	public void setUserPhoneId(long userPhoneId) {
//		this.userPhoneId = userPhoneId;
//	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserPhoneId() {
		return userPhoneId;
	}

	public void setUserPhoneId(String userPhoneId) {
		this.userPhoneId = userPhoneId;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	
	
	
	
	

}
