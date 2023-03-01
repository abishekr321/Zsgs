package com.zsgs.thirukuralapplication.athigaramsearch;

import java.util.List;

import com.zsgs.thirukuralapplication.dto.Thirukural;


public class AthigaramSearchController implements AthigaramSearchControllerCallBack,AthigaramSearchModelControllerCallBack{

	private AthigaramSearchViewCallback athigaramSearchView;
	private AthigaramSearchModelCallBack athigaramSearchModel;
	
	public AthigaramSearchController(AthigaramSearchViewCallback athigaramSearchView ) {
		this.athigaramSearchView = athigaramSearchView;
		this.athigaramSearchModel = new AthigaramSearchModel(this);
	}

	
	public void searchAthigaram(String athigaramNumber) {
		
		
		int number=0;
		try {
			 number = Integer.parseInt(athigaramNumber);
			if (number < 1 || number > 133) {
				throw new NumberFormatException();
			}
		}
		catch(Exception e) {
			athigaramSearchView.invalidSelection();
		}
		athigaramSearchModel.searchKuralAthigaram(number);
		
		
	}


	public void processFailure() {
	
		athigaramSearchView.errorMessage();
	}


	public void kuralAthigaramList(List<Thirukural> tenThirukural,List list) {
		String athigaramName=(String) list.get(0);
		Long[] number = new Long[10];
		String[] line1 = new String[10];
		String[] line2 = new String[10];
		String[] tamilExplanation= new String[10];
		String[] translation = new String[10];
		String[] englishTranslation = new String[10];
		int i=0;
		while(i<10) {
			number[i]=tenThirukural.get(i).getNumber();
			line1[i]=tenThirukural.get(i).getLine1();
			line2[i]=tenThirukural.get(i).getLine2();
			tamilExplanation[i]=tenThirukural.get(i).getTamilexplanation();
			translation[i]=tenThirukural.get(i).getTranslation();
			englishTranslation[i]=tenThirukural.get(i).getEnglishTranslation();
			i++;
		}
		
		athigaramSearchView.showAllKuralInAthigaram(athigaramName,number,line1,line2,tamilExplanation,translation,englishTranslation);
		
	}


	public void decideOption(int option) {
	   if(option==1) athigaramSearchView.athigaramMenu();
	   if(option==2)athigaramSearchView.goBack();
	}
}

