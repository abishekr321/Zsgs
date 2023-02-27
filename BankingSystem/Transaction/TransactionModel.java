package com.BankingSystem.Transaction;

import java.util.List;

import com.BankingSystem.Repository.BankAccountsRepository;
import com.BankingSystem.dto.CustomerAccounts;
import com.BankingSystem.dto.Transaction;


public class TransactionModel implements TransactionModelCallBack{
	private CustomerAccounts Receiverinfo;
	private Double balance;
	
	private TransactionModelControllerCallBack transactionController;

	public TransactionModel(TransactionModelControllerCallBack transactionController) {
		this.transactionController = transactionController;
	}

	@Override
	public void DepositMoney(long accountNumber,double amount) {
	       BankAccountsRepository.getInstance().depositMoney( accountNumber,amount);
		
	}

	@Override
	public void confirmReceiver(long accountNumber) {
		Receiverinfo=BankAccountsRepository.getInstance().getPassBook( accountNumber);
		if(Receiverinfo!=null) {
			transactionController.confirmSuccess(Receiverinfo);
		}
		else {
			transactionController.confirmFailure("No such account found");
		}
		
	}

	@Override
	public void SendingMoney(long accountNumber, long receiverAccountNumber, double amount) {
		if(BankAccountsRepository.getInstance().debitMoney( accountNumber,receiverAccountNumber,amount)) {
			transactionController.sendingSuccess("Ammount has been successfully transfered");
		}
		else {
			transactionController.sendingFailure("Insufficient Balance");
		}
		
	}

	@Override
	public void viewBalance(Long accountNumber) {
		balance=BankAccountsRepository.getInstance().viewBalance(accountNumber);
		if(balance!=null) {
		     transactionController.showBalance(balance);
		}
	}

	@Override
	public  List<Transaction> transactionHistory(long accountNumber) {
		return BankAccountsRepository.getInstance().gettransactionHistory(accountNumber);
		
	}

}
