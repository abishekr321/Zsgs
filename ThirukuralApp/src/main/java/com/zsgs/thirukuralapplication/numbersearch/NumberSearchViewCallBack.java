package com.zsgs.thirukuralapplication.numbersearch;

import com.zsgs.thirukuralapplication.dto.Thirukural;

public interface NumberSearchViewCallBack {

	void invalidInput();

	void selectAuthor(String number);

	void invalidAuthorOption(String number);

	void printErrorMessage(String string);

	void exceptionOccured();

	void displayKural(Thirukural thirukural);

	void searchMenu();

	void goBackToMainMenu();

}
