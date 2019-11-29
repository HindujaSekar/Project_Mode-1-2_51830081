package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.CustomerForm;
import com.bankapp.web.formbeans.DepositWithdrawBean;
import com.bankapp.web.formbeans.FundTransferBean;

@RestController
@RequestMapping(path="/api/tx")
public class AccountRestController {
	@Autowired
	private AccountService service;
	
	
	@GetMapping(path="home")
	public String home(){
		return "hello";
	}
		
	@PutMapping(path="fundtransfer",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> fundTransfer(@RequestBody FundTransferBean bean){
		return new ResponseEntity<Void>(service.transfer(bean.getFromAccount(),
				bean.getToAccount(), bean.getAmount()),HttpStatus.OK);
		
	}
	@PutMapping(path="deposit",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> deposit(@RequestBody DepositWithdrawBean bean){
		return new ResponseEntity<Account>(service.deposit(bean.getFromAccount(),
				 bean.getAmount()),HttpStatus.OK);
		
	}
	@PutMapping(path="withdraw",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> withdraw(@RequestBody DepositWithdrawBean bean){
		return new ResponseEntity<Account>(service.withdraw(bean.getFromAccount(),
				bean.getAmount()),HttpStatus.OK);
		
	}
	@DeleteMapping(path="account/{accountNumber}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAccount(
			@PathVariable(name="accountNumber") long accountNumber){
		service.deleteAccount(accountNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping(path="editaccount/{accountNumber}",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> editAccount(@RequestBody CustomerForm customerForm
			,@PathVariable(name="accountNumber") long accountNumber){
		Customer customer=service.getCustomerById(accountNumber);
		customer.setName(customerForm.getName());
		customer.setEmail(customerForm.getEmail());
		customer.setPhone(customerForm.getPhone());
		customer.setAddress(customerForm.getAddress());
		customer.setCity(customerForm.getCity());
		customer.setCountry(customerForm.getCountry());
		Account account=service.getAccountById(accountNumber);
		account.setCustomer(customer);
		customer.setAccount(account);
		return new ResponseEntity<Account>(service.editAccount(account),HttpStatus.OK);
	}
	
}
