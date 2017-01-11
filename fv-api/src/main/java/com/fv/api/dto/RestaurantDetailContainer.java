package com.fv.api.dto;

import java.util.List;

public class RestaurantDetailContainer extends Response{
	boolean hasMoreProducts;
	  private List<RestaurantDetail> restaurantDetailList;
	public List<RestaurantDetail> getRestaurantDetailList() {
		return restaurantDetailList;
	}
	public void setRestaurantDetailList(List<RestaurantDetail> restaurantDetailList) {
		this.restaurantDetailList = restaurantDetailList;
	}
	public boolean isHasMoreProducts() {
		return hasMoreProducts;
	}
	public void setHasMoreProducts(boolean hasMoreProducts) {
		this.hasMoreProducts = hasMoreProducts;
	}
}
