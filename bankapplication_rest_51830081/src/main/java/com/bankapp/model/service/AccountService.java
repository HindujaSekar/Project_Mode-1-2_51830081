package com.bankapp.model.service;

import java.util.List;


import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;

public interface AccountService {
	List<Account> getAllAccounts();
	Account getAccountById(long id);
	Customer getCustomerById(long id);
	Account editAccount(Account account);
	Void deleteAccount(long accountNumber);
	void blockAccount(long accountNumber);
	Account createAccount(Account account );
	Account deposit(Long accountNumber, double amount);
	Account withdraw(Long accountNumber, double amount);
    Void transfer(Long fromAccNumber, Long toAccNumber, double amount);
}
