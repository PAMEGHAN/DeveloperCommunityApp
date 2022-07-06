package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private String userId;
	 @Column(name="userpassword")
	 private String password;
	 @Column(name="userrole")
	 private String role;
	 
	 public User() {}


	public User(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}

	
}
