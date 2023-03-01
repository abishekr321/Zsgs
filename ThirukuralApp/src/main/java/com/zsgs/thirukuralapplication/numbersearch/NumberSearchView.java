package com.zsgs.thirukuralapplication.numbersearch;

import java.util.Scanner;

import com.zsgs.thirukuralapplication.dto.Thirukural;
import com.zsgs.thirukuralapplication.homepage.HomePageView;



public class NumberSearchView implements NumberSearchViewCallBack{

	private NumberSearchControllerCallBack numberSearchController;
	private Scanner scanner  = new Scanner(System.in);
	public NumberSearchView() {
		this.numberSearchController = new NumberSearchController(this);
	}
	HomePageView homePageView = new HomePageView();
	public void searchMenu() {
		
		System.out.println("குறள் எண்ணை தேர்வு செய்க(1-1330): ");
	    String number = scanner.next();
	   
	    
		System.out.println("உரையாசிரியரை தேர்வு செய்ய விருப்பமா? (1=ஆம்/2=இல்லை) ");
		String option = scanner.next();
		
		numberSearchController.searchKural(number,option);
	}
	
	
	public void invalidInput() {
		System.out.println("உங்கள் தேர்வு தவறானது. மீண்டும் தேர்வு செய்க");
		searchMenu();
	}

	
	public void selectAuthor(String number) {
		System.out.println("மு.வரதராசனார் உரைக்கு எண் ஒன்றை(1) அழுத்தவும்");
		System.out.println("பரிமேலழகர் உரைக்கு எண் இரண்டை(2) அழுத்தவும்");
	    System.out.println("மு. கருணாநிதி உரைக்கு எண் மூன்றை(3) அழுத்தவும்"); 
	    
	    String userOption = scanner.next();
	    
	    numberSearchController.selectExplanation(number,userOption);
		
	}
	
	public void invalidAuthorOption(String number) {
		System.out.println("உங்கள் தேர்வு தவறானது. மீண்டும் தேர்வு செய்க");
		selectAuthor(number);
	}

	
	public void printErrorMessage(String string) {
		System.out.println(string);
		
	}

	public void exceptionOccured() {
		System.out.println("error");
		
	}

	
	public void displayKural(Thirukural thirukural) {
		System.out.println("குறள் எண் "+thirukural.getNumber());
		System.out.println("----------------------------------------------");
		System.out.println(" "+thirukural.getLine1());
		System.out.println(" "+thirukural.getLine2());
		System.out.println("----------------------------------------------");
		System.out.println("தமிழ் விளக்கம்: "+thirukural.getTamilexplanation());
		System.out.println("\nEnglish Translation: "+thirukural.getTranslation());
		System.out.println(thirukural.getEnglishTranslation());
		System.out.println("வேறு குறளை தேட வேண்டுமா? (1=ஆம்/2=இல்லை)");
		int option = scanner.nextInt();
		numberSearchController.userOption(option);
	}

	@Override
	public void goBackToMainMenu() {
		homePageView.mainMenu();
		
	}
}
