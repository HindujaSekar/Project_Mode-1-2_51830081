package com.bankapp.model.service;

import java.util.List;
import com.bankapp.model.entities.Account;

public interface AccountService {
	List<Account> getAllAccounts();
	Account getAccountById(long id);
	void blockAccount(Long accountNumber);
    void createAccount(Account account );
    Account deposit(Long accountNumber, double amount);
    Account withdraw(Long accountNumber, double amount);
    Void transfer(Long fromAccNumber, Long toAccNumber, double amount);
}
