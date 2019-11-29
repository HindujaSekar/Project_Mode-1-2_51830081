package com.custapp.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer_table")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String address;
	@NotEmpty
	private String city;
	@NotEmpty
	private String companyname;
	@NotNull
	private String phone;
	
	@NotEmpty
	@Email
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(int id, String name, String address, String city, String companyname, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.companyname = companyname;
		this.phone = phone;
		this.email = email;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", companyname="
				+ companyname + ", phone=" + phone + ", email=" + email + "]";
	} 
	
	

}
