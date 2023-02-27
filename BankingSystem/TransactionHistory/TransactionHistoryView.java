package com.BankingSystem.TransactionHistory;

import java.util.Scanner;

import com.BankingSystem.Login.LoginView;


public class TransactionHistoryView implements TransactionHistoryViewCallBack{
	private TransactionHistoryControllerCallBack transactionHistoryController;
	private Scanner scanner = new Scanner(System.in);
	

	public TransactionHistoryView(LoginView loginView) {
		transactionHistoryController = new TransactionHistoryController(this);
	}


	public void getHistory(Long accountNumber) {
		
		
	}
}
