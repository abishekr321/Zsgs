package com.BankingSystem.Transaction;

import com.BankingSystem.dto.CustomerAccounts;

public interface TransactionViewCallBack {

	void confirmSuccess(CustomerAccounts receiverinfo);

	void confirmFailure(String errorMessage);

	void sendingSuccess(String successMessage);

	void sendingFailure(String errorMessage);

	void showBalance(Double balance);

}
