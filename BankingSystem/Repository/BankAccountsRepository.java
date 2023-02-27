package com.BankingSystem.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.BankingSystem.dto.*;



public class BankAccountsRepository {

	private int accountNumberprefix;
	private int accountNumbersuffix;
	private Long accountNumber;
	private String IFSC_code;
	

	private static BankAccountsRepository bankAccountsRepository;

	private BankAccountsRepository() {

	}

	public static BankAccountsRepository getInstance() {
		if (bankAccountsRepository == null) {
			bankAccountsRepository = new BankAccountsRepository();
			bankAccountsRepository.initialSetup();
			bankAccountsRepository.branchSetup();
			
		}
		return bankAccountsRepository;
	}

	private List<Credentials> userDetails = new ArrayList<>();
	private List<CustomerAccounts> customerAccountdetails = new ArrayList<>();
	private List<String> branchNames = new ArrayList<>();
    private Map<Long,Double> balance = new HashMap();
    private List<Transaction> transactionHistory=new ArrayList<>();
    LocalDate date=LocalDate.now();
	private void initialSetup() {
		userDetails.add(new Credentials("Abishek", "R", "abishek@gmail,com", "9876543210", "Abishek", "appu"));
		userDetails.add(new Credentials("Bala", "san", "balasan@yahoo.com", "9870654321", "Bala", "appu"));
	}

	private void branchSetup() {
		branchNames.add("Anna Nagar");
		branchNames.add("T Nagar");
		branchNames.add("Guduvancherry");
	}

	public boolean verifyUser(String userId, String password) {
		for (Credentials user : userDetails) {
			if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public boolean addUser(String firstName, String lastName, String emailId, String phoneNumber, String userId,
			String password) {
		for (Credentials user : userDetails) {
			if (user.getUserId().equals(userId)) {
				return false;
			}
		}
		userDetails.add(new Credentials(firstName, lastName, emailId, phoneNumber, userId, password));
		return true;
	}



	
   
	public CustomerAccounts createNewAccounts(String firstName, String lastName, String gender, String phoneNumber,
			String emailId, Long aadharNumber, LocalDate creationDate, String panNumber, String address,
			String branch,String AccountType) {
		for (CustomerAccounts account : customerAccountdetails) {
			if (account.getAadharNumber().equals(aadharNumber) || account.getPanNumber().equals(panNumber)) {
				return null;
			}

		}
		boolean flag=true;
		for (String branchname : branchNames) {
			if (branchname.equals(branch)) {
				IFSC_code="AHAB"+(1000+branchNames.indexOf(branch)+1);
				accountNumberprefix = 1000 + branchNames.indexOf(branch)+1;
				flag=false;
				break;
			} 
		}if(flag) {
				branchNames.add(branch);
				IFSC_code="AHAB"+(1000+branchNames.indexOf(branch)+1);
				accountNumberprefix = 1000 + branchNames.indexOf(branch)+1;
			}

		
		accountNumbersuffix = 1000 + customerAccountdetails.size();
		String temporaryNumber = accountNumberprefix + "" + accountNumbersuffix;
		accountNumber = Long.parseLong(temporaryNumber);
		balance.put(accountNumber,balance.getOrDefault(accountNumber,0.0));

		customerAccountdetails.add(new CustomerAccounts(firstName, lastName, gender, phoneNumber, emailId, aadharNumber,
				creationDate, panNumber, address, branch,IFSC_code, accountNumber,AccountType));
		return customerAccountdetails.get(customerAccountdetails.size()-1);
	}

	public CustomerAccounts getAccounts(String panNumber, Long aadharNumber) {
		for (CustomerAccounts account : customerAccountdetails) {
			if (account.getAadharNumber().equals(aadharNumber) || account.getPanNumber().equals(panNumber)) {
				return account;
			}
		}
		return null;
	}
    public long getAccountNumber(String userId) {
    	for ( Credentials user : userDetails) {
			if (user.getUserId().equals(userId)) {
			         String name=user.getFirstName();
			        for(CustomerAccounts account : customerAccountdetails) {
			        	if(account.getFirstName().equalsIgnoreCase(name)) {
			        		return account.getAccountNumber();
			        	}
			        }
			}
		}
		return 0;
    }

	public void depositMoney(long accountNumber, double amount) {
		balance.put(accountNumber, balance.getOrDefault(accountNumber,0.0)+amount);
		transactionHistory.add(new Transaction(accountNumber,"Amount added by self",LocalDate.now(), amount,0.0,balance.get(accountNumber)));
	}

	public CustomerAccounts getPassBook(long accountNumber) {
		for(CustomerAccounts account : customerAccountdetails) {
			if(accountNumber==account.getAccountNumber()) {
				return account;
			}
		}
		return null;
	}

	public boolean debitMoney(long accountNumber, long receiverAccountNumber, double amount) {
		if(balance.get(accountNumber)<amount) {
			return false;
		}
		balance.put(accountNumber, balance.getOrDefault(accountNumber,0.0)-amount);
		transactionHistory.add(new Transaction(accountNumber,"Amount sent to"+receiverAccountNumber,LocalDate.now(), 0.0,amount,balance.get(accountNumber)));
		balance.put(receiverAccountNumber, balance.getOrDefault(receiverAccountNumber,0.0)+amount);
		transactionHistory.add(new Transaction(receiverAccountNumber,"Amount sent by"+accountNumber,LocalDate.now(), amount,0.0,balance.get(receiverAccountNumber)));
		return true;
	}

	public Double viewBalance(Long accountNumber) {
	   return balance.get(accountNumber);
	   
		
	}

	public List<Transaction> gettransactionHistory(long accountNumber) {
		List<Transaction> transHis=new ArrayList();
		for(Transaction transaction:transactionHistory) {
			if(transaction.getAccountNumber()==accountNumber) {
			       transHis.add(transaction);
			}
		}
		return transHis;
	}
	
}
