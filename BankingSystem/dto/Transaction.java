package com.BankingSystem.dto;

import java.time.LocalDate;
import java.util.Map;

public class Transaction {
	private long accountNumber;
	private String status;
	private LocalDate date;
	private double credited;
	private double debited;
	private double balance;
	public Transaction(long accountNumber,String status,LocalDate localDate,double credited,double debited,double balance) {
		this.accountNumber=accountNumber;
		this.status=status;
		this.date=localDate;
		this.credited=credited;
		this.debited=debited;
		this.balance=balance;
		
		
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getCredited() {
		return credited;
	}
	public void setCredited(double credited) {
		this.credited = credited;
	}
	public double getDebited() {
		return debited;
	}
	public void setDebited(double debited) {
		this.debited = debited;
	}
	

}
