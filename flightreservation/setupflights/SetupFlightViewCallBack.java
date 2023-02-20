package com.zsgs.flightreservation.setupflights;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;

public interface SetupFlightViewCallBack {

	void additionSuccess(String successMessage);

	void additionFailure(String errorMessage);

	void deletionSuccess(String successMessage);

	void deletionFailure(String errorMessage);

	void printFlights(List<Flight> viewFlights);

}
