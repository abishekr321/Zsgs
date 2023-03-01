package com.zsgs.thirukuralapplication.athigaramsearch;

import java.util.Scanner;

import com.zsgs.thirukuralapplication.homepage.HomePageView;

public class AthigaramSearchView implements AthigaramSearchViewCallback{
    HomePageView homePageView = new HomePageView();
   AthigaramSearchControllerCallBack athigaramSearchController;
	private Scanner scanner = new Scanner(System.in);
	public AthigaramSearchView() {
		this.athigaramSearchController = new AthigaramSearchController(this);
	}
	
	
	public void athigaramMenu() {
		System.out.println("அதிகாரம் எண்ணை(1-133) தேர்வு செய்க");
		String athigaramNumber = scanner.next();
		athigaramSearchController.searchAthigaram(athigaramNumber);
	}


	
	public void invalidSelection() {
		System.out.println("உங்கள் தேர்வு தவறானது. மீண்டும் தேர்வு செய்க");
		athigaramMenu();
		
	}


	public void errorMessage() {
		System.out.println("செயல்முறை தோல்வி.");
		
	}


	@Override
	public void showAllKuralInAthigaram(String athigaramName,Long[] number, String[] line1, String[] line2, String[] tamilExplanation,
			String[] translation, String[] englishTranslation) {
		int start =0;
		int end =10;
		System.out.println("-----------"+athigaramName+"------------");
		while(start<end) {
			System.out.println("குறள் எண் "+number[start]);
			System.out.println("----------------------------------------------");
			System.out.println(" "+line1[start]);
			System.out.println(" "+line2[start]);
			System.out.println("----------------------------------------------");
			System.out.println("தமிழ் விளக்கம்: "+tamilExplanation[start]);
			System.out.println("\nEnglish Translation: "+translation[start]);
			System.out.println(englishTranslation[start]+"\n");
			start++;
		}
		System.out.println("வேறு அதிகாரம் தேட வேண்டுமா? (1=ஆம்/2=இல்லை)");
		int option = scanner.nextInt();
		athigaramSearchController.decideOption(option);
		
	}
	public void goBack() {
		homePageView.mainMenu();
		
	}
	
}

