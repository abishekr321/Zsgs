package com.zsgs.efarming.setupproducts;

public class SetupProductsController implements SetupProductsControllerCallBack,SetupProductsModelControllerCallBack {
     
	private SetupProductsViewCallBack setupProductsView;
	private SetupProductsModelCallBack setupProductsModel;
	public SetupProductsController(SetupProductsViewCallBack setupProductsView) {
		this.setupProductsView = setupProductsView;
		setupProductsModel = new SetupProductsModel(this);
	}
	@Override
	public void addProducts(String productName, float quantity, float price) {
		setupProductsModel.addProducts(productName,quantity,price);
		
	}
	@Override
	public void AdditionSuccess(String successMessage) {
		setupProductsView.AdditionSuccess(successMessage);
		
	}
	@Override
	public void AdditionFailure(String failureMessage) {
		setupProductsView.AdditionFailure(failureMessage);
		
	}
	
}
