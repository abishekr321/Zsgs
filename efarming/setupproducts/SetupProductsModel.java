package com.zsgs.efarming.setupproducts;

import com.zsgs.efarming.repository.DbRepository;

public class SetupProductsModel implements SetupProductsModelCallBack {
	private SetupProductsModelControllerCallBack setupProductsController;

	public SetupProductsModel(SetupProductsModelControllerCallBack setupProductsController) {
		this.setupProductsController = setupProductsController;
	}

	@Override
	public void addProducts(String productName, float quantity, float price) {
		if(DbRepository.getInstance().addProducts(productName,quantity,price)) {
			setupProductsController.AdditionSuccess("Added Successfully");
			}
		else {
			setupProductsController.AdditionFailure("Failed to Add");
		}
		
	}
	

}
