package com.zsgs.coursemanagement.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format.*;
import java.time.*;

public class Validate {

	public static boolean Email(String emailAddress) {
		Pattern pattern =Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][a-zA-Z0-9]*{2}+[.]*+[a-zA-Z0-9]{2,6}");
		Matcher matcher = pattern.matcher(emailAddress);
		if((matcher.matches())) {
		return true;}
		return false;
	}

	public static boolean mobileNumber(String mobileNumber) {
		Pattern pattern =Pattern.compile("[6-9][0-9]{9}");
		Matcher matcher = pattern.matcher(mobileNumber);
		if((matcher.matches())) {
		return true;}
		return false;
	
}

	public static boolean validpassword(String password, String password1) {
		if(password.equals(password1)) {
			return true;
		}
		return false;
	}
	public  static LocalDate dateformat(String date) {
		DateTimeFormatter formatDate=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate formattedDate= LocalDate.parse(date, formatDate);
		return formattedDate;
		
	}
	public static LocalTime timeFormat(String time) {
		LocalTime formattedtime=LocalTime.parse(time);
		return formattedtime;
	}

}
