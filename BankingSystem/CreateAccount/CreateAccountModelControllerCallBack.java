package com.BankingSystem.CreateAccount;

import com.BankingSystem.dto.CustomerAccounts;

public interface CreateAccountModelControllerCallBack {

	void AccountCreationSuccess(CustomerAccounts customerPassBook);

	void AccountCreationFailure(CustomerAccounts customerPassBook,String errorMessage);

}
