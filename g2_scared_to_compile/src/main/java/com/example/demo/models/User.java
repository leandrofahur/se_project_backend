package com.example.demo.models;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_GENERATOR")
	private long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "isAdmin")
	private boolean isAdmin;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	//mappedBy = "user": the class name with small letter
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserPhone> userPhone = new HashSet<>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserAddress> userAddress = new HashSet<>();
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserPayment> userPayment = new HashSet<>();
	
	public User() {}

	//public User(String firstName, String lastName, String userName, String password, boolean is_admin, String email) {
	public User(String firstName, String lastName, String userName, String password, boolean is_admin, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.isAdmin = is_admin;
		this.email = email;
		
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	//public User(String userName, String email, String password, String confirmPassword) {
	public User(String userName, String email, String password) {
		super();
	
		this.userName = userName;
		this.email = email;
		this.password = password;
		//setPassword(confirmPassword);
		//this.password = confirmPassword;
		
		this.createdAt = new Date();
		//this.updatedAt = new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean is_admin) {
		this.isAdmin = is_admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<UserPhone> getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(Set<UserPhone> userPhone) {
		this.userPhone = userPhone;
	}

	public Set<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Set<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

	public Set<UserPayment> getUserPayment() {
		return userPayment;
	}

	public void setUserPayment(Set<UserPayment> userPayment) {
		this.userPayment = userPayment;
	}

	public void addUserPhoneInfo(UserPhone userPhone) {
		this.userPhone.add(userPhone);
		userPhone.setUser(this);
	}
	
	public void addUserAddressInfo(UserAddress userAddress) {
		this.userAddress.add(userAddress);
		userAddress.setUser(this);
	}
	
	public void addUserPaymentInfo(UserPayment userPayment) {
		this.userPayment.add(userPayment);
		userPayment.setUser(this);
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
//	public void removeUserPhoneInfo(UserPhone userPhone) {
//	userPhone.getUser().remove(this);
//	this.userPhone.remove(userPhone);
//}

}
