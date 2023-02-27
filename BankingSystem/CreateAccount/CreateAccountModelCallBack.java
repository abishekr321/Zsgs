package com.BankingSystem.CreateAccount;

import java.time.LocalDate;

public interface CreateAccountModelCallBack {

	void createAccount(String firstName, String lastName, String gender, String phoneNumber, String emailId,
			Long aadharNumber, LocalDate creationDate, String panNumber, String address, String branch,String accountType);

	
			

}
