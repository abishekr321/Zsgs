package com.BankingSystem.Transaction;

import com.BankingSystem.dto.CustomerAccounts;

public interface TransactionModelControllerCallBack {

	void confirmSuccess(CustomerAccounts receiverinfo);

	void confirmFailure(String string);

	void sendingSuccess(String string);

	void sendingFailure(String string);

	void showBalance(Double balance);

}
