package com.zsgs.thirukuralapplication.athigaramsearch;

import java.util.ArrayList;
import java.util.List;

import com.zsgs.thirukuralapplication.dto.Thirukural;
import com.zsgs.thirukuralapplication.repository.ThirukuralRepository;


public class AthigaramSearchModel implements AthigaramSearchModelCallBack {
	private List list = new ArrayList();
	private AthigaramSearchModelControllerCallBack athigaramSearchController;
	public AthigaramSearchModel(AthigaramSearchModelControllerCallBack athigaramSearchController) {
		this.athigaramSearchController = athigaramSearchController;
	}
	
	public void searchKuralAthigaram(int number) {
		
		
	
		list = ThirukuralRepository.getInstance().thirukuralAthigaramName(number);
		if(list.isEmpty()) {
			
			athigaramSearchController.processFailure();
		}
		else {
			List<Thirukural>tenThirukural =ThirukuralRepository.getInstance().getAllThirukuralFromAthigaram((long)list.get(1)-1);
			
			athigaramSearchController.kuralAthigaramList(tenThirukural,list);
		}
	}
}