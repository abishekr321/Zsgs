package com.zsgs.efarming.shopproducts;

import java.util.List;

import com.zsgs.efarming.dto.Orders;
import com.zsgs.efarming.dto.Products;

public interface ShopProductsControllerCallBack {

	List<Products> getProducts();

	void placeOrders(String userId, String productId, String productName, float quantity, float amount);

	List<Orders> getOrders(String userId);

}
