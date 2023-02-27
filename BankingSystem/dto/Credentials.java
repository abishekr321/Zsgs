package com.BankingSystem.dto;

public class Credentials extends User {
	  private String password;
	  
	  public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Credentials(String firstName, String lastName, String emailId, String phoneNumber, String userId, String password) {
			super.setFirstName(firstName);
			super.setLastName(lastName);
			super.setEmailId(emailId);
			super.setPhoneNumber(phoneNumber);
			super.setUserId(userId);
			this.password=password;;
		}     
		
		
}
