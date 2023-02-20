package com.zsgs.flightreservation.setupflights;

public interface SetupFlightControllerCallBack {

	void addFlights(String arrival, String departure, String flightNo, String flightName, String arrivalTime,
			String departureTime, String fare);

	void deleteFlights(String flightNo);

	void viewFlights();

}
