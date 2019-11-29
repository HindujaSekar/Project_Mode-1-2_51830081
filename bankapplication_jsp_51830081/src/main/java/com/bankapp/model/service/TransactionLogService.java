package com.bankapp.model.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bankapp.model.entities.TransactionLog;


public interface TransactionLogService {
	List<TransactionLog> getAllTransactionLogs();
	List<TransactionLog> findByTimeStampBetween(
			LocalDateTime fromTime, LocalDateTime toTime);
	List<TransactionLog> findByFromAccount(Long fromAccount);
}
