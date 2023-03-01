package com.zsgs.thirukuralapplication.homepage;

import java.util.Scanner;

import com.zsgs.thirukuralapplication.repository.ThirukuralRepository;

public class HomePageModel implements HomePageModelCallBack {
		
		private HomePageModelControllerCallBack  homePageController;
		
		public HomePageModel(HomePageModelControllerCallBack homePageController) {
			this.homePageController = homePageController;
		}

		
		public void getSpecialities() {
			Scanner scanner = ThirukuralRepository.getInstance().getSpecialities();
			
			if(scanner==null)homePageController.errorMessage();
			else homePageController.printSpecialities(scanner);
			
		}


		public void getHistory() {
			Scanner scanner = ThirukuralRepository.getInstance().getHistory();
			if(scanner==null)homePageController.errorMessage();
			else homePageController.printHistory(scanner);
			
		}
}

