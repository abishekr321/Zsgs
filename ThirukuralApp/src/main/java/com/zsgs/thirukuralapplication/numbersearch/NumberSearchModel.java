package com.zsgs.thirukuralapplication.numbersearch;

import com.zsgs.thirukuralapplication.dto.Thirukural;
import com.zsgs.thirukuralapplication.repository.ThirukuralRepository;

public class NumberSearchModel implements NumberSearchModelCallBack{
	
	private NumberSearchModelControllerCallBack numberSearchController;
	
	public NumberSearchModel(NumberSearchModelControllerCallBack numberSearchController) {
		this.numberSearchController = numberSearchController;
	}

	
	

	
	public void getThirukural(long number, String author) {
		Thirukural thirukural =  ThirukuralRepository.getInstance().getThirukuralRepository((int)number, author);
		if(thirukural==null) numberSearchController.exception();
		else numberSearchController.displayThirukural(thirukural);
		
	}
}
