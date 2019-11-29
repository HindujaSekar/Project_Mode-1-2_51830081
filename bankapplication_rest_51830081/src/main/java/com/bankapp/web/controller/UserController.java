package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.AccountForm;

@RestController
@RequestMapping(path="/api/user")
public class UserController {
	@Autowired
	private AccountService service;
	@Autowired
	private UserService uService;
	
	@GetMapping(path="allusers", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers(){
		
		return new ResponseEntity<List<User>> (uService.findAll(),HttpStatus.OK);
		
	}
	
	@PostMapping(path="account",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccount(@RequestBody AccountForm accountform){
		
		Customer customer=new Customer(accountform.getName(),
				accountform.getEmail(),
				accountform.getPhone(), accountform.getAddress(),
				accountform.getCity(), accountform.getCountry());
		Account account=new Account(accountform.getBalance(), customer, accountform.isBlocked());
		customer.setAccount(account);
		
		return new ResponseEntity<Account>(service.createAccount(account),HttpStatus.OK);
	}
}
