package com.bankapp.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="user_table")
public class User {
	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@JsonIgnore
	private String password;
	
	@Column(unique=true)
	private String email;
	
	private String phone;
	private String address;
	
	@JsonIgnore
	private String[] roles;

	private boolean active;


	public User() {}


	public User(String name, String password, String email, String phone,
			String address, String[] roles, boolean active) {
		super();
		this.name = name;
		//this.password = password;
		setPassword(password);
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.roles = roles;
		this.active = active;
	}



	public static BCryptPasswordEncoder getEncoder() {
		return encoder;
	}

	public static void setEncoder(BCryptPasswordEncoder encoder) {
		User.encoder = encoder;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encoder.encode(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}



