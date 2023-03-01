package com.zsgs.thirukuralapplication.athigaramsearch;

import java.util.List;

import com.zsgs.thirukuralapplication.dto.Thirukural;


public interface AthigaramSearchModelControllerCallBack {

	void processFailure();

	void kuralAthigaramList(List<Thirukural> tenThirukural, List list);

}