package com.BankingSystem.Transaction;

import java.util.List;
import java.util.Scanner;

import com.BankingSystem.Login.LoginView;
import com.BankingSystem.dto.CustomerAccounts;
import com.BankingSystem.dto.Transaction;


public class TransactionView implements TransactionViewCallBack{

	
	private TransactionControllerCallBack transactionController;
	private Scanner scanner = new Scanner(System.in);
	private long accountNumber;
	private LoginView loginView;

	public TransactionView(LoginView loginView) {
		this.loginView=loginView;
		transactionController = new TransactionController(this);
	}
	public void transactionMenu(long accountNumber) {
		this.accountNumber=accountNumber;
		System.out.println("Enter 1 to Deposit Money\nEnter 2 to Send Money to Others\nEnter 3 to view Balance\nEnter 4 to Transaction History\nEnter 5 to Back");
	   int choice =scanner.nextInt();
	   switch(choice) {
	   case 1:
		   DepositMoney(accountNumber);
		   break;
	   case 2:
		   SendMoney(accountNumber);
		   break;
	   case 3:
		    viewBalance(accountNumber);
		    break;
	   case 4:
		   transactionHistory(accountNumber); 
	   case 5:
		   loginView.menu(accountNumber);
	   }
	   
	   
	}
	private void transactionHistory(long accountNumber) {
		printTransaction(transactionController.transactionHistory(accountNumber));
		transactionMenu(accountNumber);
	}
	private void printTransaction(List<Transaction> transactionHistory) {
        System.out.printf("%-15s%-35s%-15s%-15s%-15s%n","Date","Status","Credit(Rs)","Debit(Rs)","Balance(Rs)");
		for(Transaction transaction :transactionHistory) {
			System.out.printf("%-15s%-35s%-15s%-15s%-15s%n",transaction.getDate(),transaction.getStatus(),transaction.getCredited(),transaction.getDebited(),transaction.getBalance());
		}
		
	}
	private void viewBalance(long accountNumber) {
	   transactionController.viewBalance(accountNumber);
	   transactionMenu(accountNumber);
		
	}
		private void SendMoney(long accountNumber) {
		System.out.println("Enter the  receiver's account Number");
		long recieverAccountNumber=scanner.nextLong();
		transactionController.confirmReceiver(recieverAccountNumber);
	}
	private void DepositMoney(long accountNumber) {
		System.out.println("Enter amount to be deposited in Your account");
		double amount=scanner.nextDouble();
		transactionController.DepositMoney(accountNumber,amount);
		System.out.println("Amount Successfully added");
		transactionMenu(accountNumber);
	}
	@Override
	public void confirmSuccess(CustomerAccounts receiverinfo) {
		System.out.printf("%-50s%n",receiverinfo.getFirstName()+" "+receiverinfo.getLastName());
		System.out.printf("%-25s%-15s%n","Account Number:",receiverinfo.getAccountNumber());
		System.out.printf("%-25s%-15s%n","IFSC code",receiverinfo.getIFSCcode());
		System.out.printf("%-25s%-15s%n","Account Type",receiverinfo.getaccountType());	
		System.out.println("\nEnter 1 for comfirm to Send\n Enter 2 to cancel");
		int choice =scanner.nextInt();
		switch (choice){
		case 1:
			SendingMoney(accountNumber,receiverinfo.getAccountNumber());
			break;
		case 2:
			transactionMenu(accountNumber);
			
		}
			
		
	}
	private void SendingMoney(long accountNumber,long receiverAccountNumber) {
		System.out.println("Enter amount to be send to receiver");
		double amount=scanner .nextDouble();
		transactionController.SendingMoney(accountNumber,receiverAccountNumber,amount);
		
	}
	@Override
	public void confirmFailure(String errorMessage) {
		System.out.println(errorMessage);
		transactionMenu(accountNumber);
		
	}
	@Override
	public void sendingSuccess(String successMessage) {
		System.out.println(successMessage);
		transactionMenu(accountNumber);
		
		
	}
	@Override
	public void sendingFailure(String errorMessage) {
        System.out.println(errorMessage);
        transactionMenu(accountNumber);
	}
	@Override
	public void showBalance(Double balance) {
		System.out.println("Your current Balance is Rs."+balance);
		transactionMenu(accountNumber);
		
	} 
}
