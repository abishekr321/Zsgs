package com.BankingSystem.CreateAccount;

import com.BankingSystem.dto.CustomerAccounts;

public interface CreateAccountViewCallBack {

	void AccountCreationSuccess(CustomerAccounts customerPassBook);

	void AccountCreationFailure(CustomerAccounts customerPassBook,String errorMessage);

}
