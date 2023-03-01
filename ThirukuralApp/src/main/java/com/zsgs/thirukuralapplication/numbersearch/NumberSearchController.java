package com.zsgs.thirukuralapplication.numbersearch;

import com.zsgs.thirukuralapplication.dto.Thirukural;

public class NumberSearchController implements NumberSearchControllerCallBack, NumberSearchModelControllerCallBack {

	private NumberSearchViewCallBack numberSearchView;
	private NumberSearchModelCallBack numberSearchModel;

	public NumberSearchController(NumberSearchViewCallBack numberSearchView) {
		this.numberSearchView = numberSearchView;
		this.numberSearchModel = new NumberSearchModel(this);
	}

	public void searchKural(String number, String option) {
		try {
			long num = Long.parseLong(number);
			if (num < 1 || num > 1330) {
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			numberSearchView.invalidInput();
		}

		switch (option) {
		case ("1"):
			numberSearchView.selectAuthor(number);
			break;

		case ("2"):
			numberSearchModel.getThirukural( Long.parseLong(number),"mk");
			break;

		default:
			numberSearchView.invalidInput();
			break;
		}
	}

	public void selectExplanation(String number, String userOption) {

		switch (userOption) {
		case ("1"):
			numberSearchModel.getThirukural( Long.parseLong(number), "mv");
			break;
		case ("2"):
			numberSearchModel.getThirukural( Long.parseLong(number), "sp");
			break;
		case ("3"):
			numberSearchModel.getThirukural( Long.parseLong(number), "mk");
			break;
		default:
			numberSearchView.invalidAuthorOption(number);
		}
	}




	public void exception() {
		
		numberSearchView.exceptionOccured();
	}

	
	public void displayThirukural(Thirukural thirukural) {
		
		numberSearchView.displayKural(thirukural);
	}

	@Override
	public void userOption(int option) {
		if(option==1)numberSearchView.searchMenu();
		else numberSearchView.goBackToMainMenu();
		
	}
}
