package com.zsgs.flightreservation.setupflights;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;
import com.zsgs.flightreservation.repository.FlightRepository;

public class SetupFlightModel implements SetupFlightModelCallBack {
	private SetupFlightControllerModelCallBack setupFlightController;

	public SetupFlightModel(SetupFlightControllerModelCallBack setupFlightController) {
		this.setupFlightController=setupFlightController;
	}

	@Override
	public void addFlights(String arrival, String departure, String flightNo, String flightName, String arrivalTime,
			String departureTime, String fare) {
		if(FlightRepository.getInstance().adminAddFlightSetup(arrival, departure, flightNo, flightName, arrivalTime, departureTime, fare)){
			setupFlightController.additionSuccess( flightName+"Added Successfully");
		}
		else {
			setupFlightController.additionFailure("Already Exist");
		}
		
		
	}

	@Override
	public void deleteFlights(String flightNo) {
		if(FlightRepository.getInstance().adminDeleteFlightSetup(flightNo)){
			setupFlightController.deletionSuccess( flightNo+"Removed Successfully");
		}
		else {
			setupFlightController.deletionFailure("No such Flight Exist");
		}
		
	}

	@Override
	public void viewFlights() {
		setupFlightController.printFlights(FlightRepository.getInstance().viewFlights());	
	} 
	
	



}
