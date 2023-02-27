package com.BankingSystem.CreateAccount;

import java.time.LocalDate;

import com.BankingSystem.Repository.BankAccountsRepository;
import com.BankingSystem.dto.CustomerAccounts;

public class CreateAccountModel implements CreateAccountModelCallBack{
	private CustomerAccounts customerPassBook; 
	private CreateAccountModelControllerCallBack createAccountController;

	public CreateAccountModel(CreateAccountModelControllerCallBack createAccountController) {
		this.createAccountController = createAccountController;
	}
	
	
	


	@Override
	public void createAccount(String firstName, String lastName, String gender, String phoneNumber,
			String emailId, Long aadharNumber, LocalDate creationDate, String panNumber, String address,
			String branch,String accountType) {
		customerPassBook=BankAccountsRepository.getInstance().createNewAccounts(firstName, lastName, gender, phoneNumber, emailId, aadharNumber, creationDate, panNumber, address,branch,accountType);
		if(customerPassBook!=null) {
			createAccountController.AccountCreationSuccess(customerPassBook);
		}
		else {
			customerPassBook=BankAccountsRepository.getInstance().getAccounts(panNumber,aadharNumber);	
					createAccountController.AccountCreationFailure(customerPassBook,"Already Account Exist");
		}
		
	}









}
