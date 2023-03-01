package com.zsgs.thirukuralapplication.homepage;

import java.util.Scanner;

import com.zsgs.thirukuralapplication.athigaramsearch.AthigaramSearchView;
import com.zsgs.thirukuralapplication.numbersearch.NumberSearchView;

public class HomePageView implements HomePageViewCallBack {
	private HomePageControllerCallBack homePageController;
	private Scanner scanner  = new Scanner(System.in);
	public HomePageView() {
		homePageController= new HomePageController(this);
	}
	
	
	public static void main(String args[]) {
		HomePageView homePageView = new HomePageView();
		homePageView.mainMenu();
	
	}
	public void mainMenu() {
		System.out.println("\n**********திருக்குறள் செயலிக்கு உங்களை வரவேற்கிறோம்***********\n");
		
		
		System.out.println("திருக்குறளை எண் வாரியாக தேட எண் ஒன்றை(1) அழுத்தவும்");
		System.out.println("திருக்குறளை அதிகாரம் வாரியாக தேட எண் இரண்டை(2) அழுத்தவும்");
		System.out.println("திருக்குறளின் சிறப்புகளை பற்றி அரிய எண் மூன்றை(3) அழுத்தவும்");
		System.out.println("திருக்குறளின் வரலாற்றை பற்றி அரிய எண் நான்கை (4) அழுத்தவும்");
		System.out.println("வெளியேற எண் ஐந்தை(5) அழுத்தவும்");
		
		String option = scanner.next();
		
		homePageController.chooseOption(option);
		
	}


	public void numberSearch() {
		NumberSearchView  numberSearchView= new NumberSearchView();   
		numberSearchView.searchMenu()  ;
		
	}


	
	public void athigaramSearch() {
		AthigaramSearchView athigaramSearchView = new AthigaramSearchView();
		athigaramSearchView.athigaramMenu();
	}


	public void specialitiesSearch() {
	   
		homePageController.fetchSpeacialities();
	}

	public void historySearch() {
	
		homePageController.fetchHistory();
		
		
	}
	public void invalidOptions(){
		System.out.println("Invalid option\n");
		mainMenu();
	}


	public void printError() {
		System.out.println("செயல்முறை தோல்வி");
		
	}


	public void printKuralSpecialities(Scanner scanner) {
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		mainMenu();
		
	}


	public void printKuralHistory(Scanner scanner) {
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		
		mainMenu();
	}

	public void printThankyou() {
		System.out.println("\n****************** நன்றி *******************\n");
		return;
		
	}

}
