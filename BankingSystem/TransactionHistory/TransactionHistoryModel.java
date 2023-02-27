package com.BankingSystem.TransactionHistory;

public class TransactionHistoryModel implements TransactionHistoryModelCallBack{

	private TransactionHistoryModelControllerCallBack transactionHistoryController;

	public TransactionHistoryModel(TransactionHistoryModelControllerCallBack transactionHistoryController) {
		this.transactionHistoryController = transactionHistoryController;
	}
}
