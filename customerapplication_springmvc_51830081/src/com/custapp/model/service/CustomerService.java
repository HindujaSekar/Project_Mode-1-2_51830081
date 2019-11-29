package com.custapp.model.service;

import java.util.List;

import com.custapp.model.persistance.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int customerId);
	public Customer addCustomer(Customer customer );
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int customerId);
}


