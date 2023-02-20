package com.zsgs.flightreservation.setupflights;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;

public interface SetupFlightControllerModelCallBack {

	void additionSuccess(String string);

	void additionFailure(String string);

	void deletionSuccess(String string);

	void deletionFailure(String string);

	void printFlights(List<Flight> viewFlights);


}
