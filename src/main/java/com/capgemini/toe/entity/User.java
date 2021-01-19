package com.capgemini.toe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long userId;
	
	@NotNull
	private String userName;
	
	@Email
	private String userEmail;
	
	@NotNull
	private String password;
	
	@NotNull
	private String role;
	/**
	 * 1.Candidate
	 * 2.Instructor
	 */
	
	public User() {
		super();
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public User(long userId, @NotNull String userName, @Email String userEmail, @NotNull String password,
			@NotNull String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.role = role;
	}

	
}
