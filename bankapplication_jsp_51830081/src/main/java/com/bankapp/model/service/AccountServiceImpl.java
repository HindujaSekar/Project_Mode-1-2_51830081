package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
//import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	//@Autowired
	//private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		account.setBlocked(true);
		accountRepository.save(account);
	}

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
		customerRepository.save(account.getCustomer());
	}

	@Override
	public Account deposit(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);
		AccountTransaction accountTransaction=new AccountTransaction("deposit", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log=new TransactionLog
				(accountNumber, null, "deposit", amount, account.getCustomer().getName(), "done");
		transactionLogRepository.save(log);
		//accountTransactionRepository.save(accountTransaction);
		return account;
	}

	@Override
	public Account withdraw(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 1000)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		AccountTransaction accountTransaction=new AccountTransaction("withdraw", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log=new TransactionLog
				(accountNumber, null, "withdraw", amount, account.getCustomer().getName(), "done");
		transactionLogRepository.save(log);
		return account;
	}

	
	@Override
	public Void transfer(Long fromAccNumber, Long toAccNumber, double amount) {
		Account toAccount=getAccountById(toAccNumber);
		if (toAccount.getBalance() - amount < 1000)
			throw new NotSufficientFundException();
		toAccount.setBalance(toAccount.getBalance() + amount);
		Account fromAccount=getAccountById(fromAccNumber);
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		AccountTransaction accountTransaction=new AccountTransaction("transfer", amount);
		fromAccount.addAccountTransaction(accountTransaction);
		toAccount.addAccountTransaction(accountTransaction);
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		TransactionLog log=new TransactionLog
				(fromAccNumber, toAccNumber, 
						"transfer", amount, 
						fromAccount.getCustomer().getName(), "done");
		transactionLogRepository.save(log);
		return null;
		
		
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return (List<Account>)accountRepository.findAll();
	}

	@Override
	public Account getAccountById(long id) {
		
		return accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
	}

}




