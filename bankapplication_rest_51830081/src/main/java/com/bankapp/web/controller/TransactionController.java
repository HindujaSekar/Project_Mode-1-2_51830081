package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;

@RestController
@RequestMapping(path="/api/acc")
public class TransactionController {
	@Autowired
	private AccountService service;
	
	@Autowired
	private TransactionLogService tService;
	@GetMapping(path="allaccounts", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts(){
		return new ResponseEntity<List<Account>> (service.getAllAccounts(),HttpStatus.OK);
	}
	
	@GetMapping(path="transactions", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getAllTransactions(){
		return new ResponseEntity<List<TransactionLog>> (tService.getAllTransactionLogs(),HttpStatus.OK);
	}
	@GetMapping(path="account/{accountNumber}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccountById(@PathVariable(name="accountNumber") long accountNumber){
		return new ResponseEntity<Account> (service.getAccountById(accountNumber),HttpStatus.OK);
	}
	@GetMapping(path="transactions/{fromAccount}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getTransactionFromAccount(@PathVariable(name="fromAccount") long fromAccount){
		return new ResponseEntity<List<TransactionLog>> (tService.findByFromAccount(fromAccount),HttpStatus.OK);
	}
	

	/*@GetMapping(path="transactionsbytime",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getTransactionBetween(
			@RequestBody TimeStampForm form){
		return new ResponseEntity<List<TransactionLog>>
		(tService.findByTimeStampBetween(form.getFromTime(), form.getToTime()),HttpStatus.OK);
	}*/

}
