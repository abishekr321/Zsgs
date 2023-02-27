package com.BankingSystem.Transaction;

import java.util.List;

import com.BankingSystem.dto.Transaction;

public interface TransactionModelCallBack {

	void DepositMoney(long accountNumber, double amount);

	void confirmReceiver(long accountNumber);

	void SendingMoney(long accountNumber, long receiverAccountNumber, double amount);

	void viewBalance(Long accountNumber);

	List<Transaction> transactionHistory(long accountNumber);

}
