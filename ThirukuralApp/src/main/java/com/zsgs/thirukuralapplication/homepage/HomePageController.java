package com.zsgs.thirukuralapplication.homepage;

import java.util.Scanner;

public class HomePageController implements HomePageControllerCallBack, HomePageModelControllerCallBack{
	
	
	private HomePageViewCallBack homePageView;
	private HomePageModelCallBack homePageModel;
	
    public HomePageController(HomePageViewCallBack homePageView) {
    	this.homePageView=homePageView;
    	this.homePageModel=new HomePageModel(this);
    }

	@Override
	public void chooseOption(String option) {
		
		
		switch(option) {
		case("1"):
			homePageView.numberSearch();
			break;
		
		case("2"):
			homePageView.athigaramSearch();
			break;
		
		case("3"):
			homePageView.specialitiesSearch();
			break;
		
		case("4"):
			homePageView.historySearch();
			break;
			
		case("5"):
			homePageView.printThankyou();
			System.exit(0);

         default:
        	homePageView.invalidOptions();
			
		}
		
		
	}

	
	public void fetchSpeacialities() {
		homePageModel.getSpecialities();
		
	}


	public void fetchHistory() {
		homePageModel.getHistory();
		
	}

	
	public void errorMessage() {
		homePageView.printError();
		
	}


	public void printSpecialities(Scanner scanner) {
		homePageView.printKuralSpecialities(scanner);
	}

	public void printHistory(Scanner scanner) {
		homePageView.printKuralHistory(scanner);
		
	}
}
