package com.zsgs.efarming.shopproducts;

import java.util.List;

import com.zsgs.efarming.dto.Orders;
import com.zsgs.efarming.dto.Products;
import com.zsgs.efarming.repository.DbRepository;

public class ShopProductsModel implements ShopProductsModelCallBack {
	private ShopProductsModelControllerCallBack shopProductsController;

	public ShopProductsModel(ShopProductsModelControllerCallBack shopProductsController) {
		this.shopProductsController = shopProductsController;
	}

	@Override
	public List<Products> getProducts() {
		return DbRepository.getInstance().getProducts();
	}


	@Override
	public void placeOrders(String userId, String productId, String productName, float quantity, float amount) {
		if(DbRepository.getInstance().placeOrders(userId,productId,productName,quantity,amount)) {
			shopProductsController.additionSuccess(productName+" Addedsuccessfully");
		}
		else {
			shopProductsController.additionFailure("Addition failed");
		}
		
	}

	@Override
	public List<Orders> getOrders(String userId) {
		return DbRepository.getInstance().getOrders(userId) ;
	}
	

}

