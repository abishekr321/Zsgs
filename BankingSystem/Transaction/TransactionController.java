package com.BankingSystem.Transaction;

import java.util.List;

import com.BankingSystem.dto.CustomerAccounts;
import com.BankingSystem.dto.Transaction;

public class TransactionController implements TransactionControllerCallBack,TransactionModelControllerCallBack{

	private TransactionViewCallBack transactionView;
	private TransactionModelCallBack transactionModel;

	public TransactionController(TransactionViewCallBack transactionView) {
		this.transactionView = transactionView;
		this.transactionModel = new TransactionModel(this);
	}

	@Override
	public void viewBalance(Long accountNumber) {
		transactionModel.viewBalance(accountNumber);
		
	}

	@Override
	public void DepositMoney(long accountNumber,double amount) {
		transactionModel.DepositMoney(accountNumber,amount);
		
	}

	@Override
	public void confirmReceiver(long accountNumber) {
		transactionModel.confirmReceiver(accountNumber);
		
	}

	public  void confirmSuccess(CustomerAccounts receiverinfo) {
		transactionView.confirmSuccess(receiverinfo);
		
	}

	public  void confirmFailure(String errorMessage) {
		 transactionView.confirmFailure(errorMessage);
		
	}

	@Override
	public void SendingMoney(long accountNumber, long receiverAccountNumber, double amount) {
		transactionModel.SendingMoney(accountNumber,receiverAccountNumber,amount);
		
	}

	@Override
	public void sendingSuccess(String successMessage) {
		transactionView.sendingSuccess(successMessage);
		
	}

	@Override
	public void sendingFailure(String errorMessage) {
		transactionView.sendingFailure(errorMessage);
		
	}

	@Override
	public void showBalance(Double balance) {
		transactionView.showBalance(balance);
	}

	@Override
	public  List<Transaction> transactionHistory(long accountNumber) {
		 return transactionModel.transactionHistory(accountNumber);
		
	}
	
}
