package com.BankingSystem.CreateAccount;

import java.time.LocalDate;

import com.BankingSystem.dto.CustomerAccounts;

public class CreateAccountController implements  CreateAccountControllerCallBack, CreateAccountModelControllerCallBack{

	
	private CreateAccountViewCallBack createAccountView;
	private CreateAccountModelCallBack createAccountModel;

	public CreateAccountController(CreateAccountViewCallBack createAccountView) {
		this.createAccountView = createAccountView;
		this.createAccountModel = new CreateAccountModel(this);
	}
	


	@Override
	public void createAccount(String firstName, String lastName, String gender, String phoneNumber, String emailId,
			Long aadharNumber, LocalDate creationDate, String panNumber, String address, String branch,
			String accountType) {
		createAccountModel.createAccount(firstName, lastName, gender, phoneNumber, emailId, aadharNumber, creationDate, panNumber, address, branch,accountType);
	}



	@Override
	public void AccountCreationSuccess(CustomerAccounts customerPassBook) {
		createAccountView.AccountCreationSuccess(customerPassBook);
		
	}



	@Override
	public void AccountCreationFailure(CustomerAccounts customerPassBook,String errorMessage) {
		createAccountView.AccountCreationFailure(customerPassBook,errorMessage);
		
	}
	
	
	
}
