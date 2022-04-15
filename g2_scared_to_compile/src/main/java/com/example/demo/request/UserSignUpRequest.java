package com.example.demo.request;

import javax.validation.constraints.NotBlank;

public class UserSignUpRequest {
	
	@NotBlank(message = "User name cannot be blank")
	private String userName;
	
	@NotBlank(message = "User email cannot be blank")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
	private String password;
	
	@NotBlank(message = "Confirm Password cannot be blank")
	private String confirmPassword;
	
	public UserSignUpRequest() {}

	public UserSignUpRequest(@NotBlank(message = "User name cannot be blank") String userName,
			@NotBlank(message = "User email cannot be blank") String email,
			@NotBlank(message = "Password cannot be blank") String password,
			@NotBlank(message = "Confirm Password cannot be blank") String confirmPassword) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	

}