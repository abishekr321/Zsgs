package com.BankingSystem.TransactionHistory;

public class TransactionHistoryController implements TransactionHistoryControllerCallBack,TransactionHistoryModelControllerCallBack{

	
	private TransactionHistoryViewCallBack transactionHistoryView;
	private TransactionHistoryModelCallBack transactionHistoryModel;

	public TransactionHistoryController(TransactionHistoryViewCallBack transactionView) {
		this.transactionHistoryView = transactionHistoryView;
		this.transactionHistoryModel = new TransactionHistoryModel(this);
	}
	
}
