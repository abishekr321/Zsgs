package com.zsgs.flightreservation.setupflights;

import java.util.List;

import com.zsgs.flightreservation.dto.Flight;

public class SetupFlightController implements SetupFlightControllerCallBack,SetupFlightControllerModelCallBack {
     private SetupFlightViewCallBack setupFlightView;
     private SetupFlightModelCallBack setupFlightModel;
	public SetupFlightController(SetupFlightView setupFlightView) {
		this.setupFlightView=setupFlightView;
		setupFlightModel= new SetupFlightModel(this);
		
	}
	@Override
	public void addFlights(String arrival, String departure, String flightNo, String flightName, String arrivalTime,
			String departureTime, String fare) {
		setupFlightModel.addFlights(arrival,departure,flightNo,flightName,arrivalTime,departureTime,fare);
		
	}
	@Override
	public void additionSuccess(String successMessage) {
		setupFlightView.additionSuccess(successMessage);
		
	}
	@Override
	public void additionFailure(String errorMessage) {
		setupFlightView.additionFailure(errorMessage);
		
	}
	@Override
	public void deleteFlights(String flightNo) {
		setupFlightModel.deleteFlights(flightNo);
		
	}
	@Override
	public void deletionSuccess(String successMessage) {
		setupFlightView.deletionSuccess(successMessage);
		
	}
	@Override
	public void deletionFailure(String errorMessage) {
		setupFlightView.deletionFailure(errorMessage);
		
	}
	@Override
	public void viewFlights() {
		setupFlightModel.viewFlights();
		
	}
	@Override
	public void printFlights(List<Flight> viewFlights) {
		setupFlightView.printFlights(viewFlights);
		
	}

}
