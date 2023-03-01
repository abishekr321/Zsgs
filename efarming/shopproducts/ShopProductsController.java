package com.zsgs.efarming.shopproducts;

import java.util.List;

import com.zsgs.efarming.dto.Orders;
import com.zsgs.efarming.dto.Products;

public class ShopProductsController implements ShopProductsControllerCallBack,ShopProductsModelControllerCallBack {
    
	private ShopProductsViewCallBack shopProductsView;
	private ShopProductsModelCallBack shopProductsModel;
	public ShopProductsController(ShopProductsViewCallBack shopProductsView) {
		this.shopProductsView = shopProductsView;
		shopProductsModel = new ShopProductsModel(this);
	}
	@Override
	public List<Products> getProducts() {
		return shopProductsModel.getProducts() ;
	}

	@Override
	public void placeOrders(String userId, String productId, String productName, float quantity, float amount) {
		shopProductsModel.placeOrders(userId,productId,productName,quantity,amount);
		
	}
	@Override
	public List<Orders> getOrders(String userId) {
		return shopProductsModel.getOrders(userId) ;
	}
	@Override
	public void additionSuccess(String successMessage) {
		shopProductsView.additionSuccess(successMessage);
		
	}
	@Override
	public void additionFailure(String failureMessage) {
		shopProductsView.additionFailure(failureMessage);
		
	}
	
}