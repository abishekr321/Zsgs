package com.BankingSystem.Transaction;

import java.util.List;

import com.BankingSystem.dto.Transaction;

public interface TransactionControllerCallBack {

	void viewBalance(Long accountNumber);

	void DepositMoney(long accountNumber, double amount);

	void confirmReceiver(long accountNumber);

	void SendingMoney(long accountNumber, long receiverAccountNumber, double amount);

	List<Transaction> transactionHistory(long accountNumber);

}
