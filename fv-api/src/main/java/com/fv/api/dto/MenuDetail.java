package com.fv.api.dto;

import java.util.List;

public class MenuDetail extends Response {

    
    private String restaurantName;
   
    private boolean isImageMenu;
    private List<PhotographDetail> photographDetailList;
    private List<CategoryDetail> categoryDetailList;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public boolean isImageMenu() {
		return isImageMenu;
	}
	public void setImageMenu(boolean isImageMenu) {
		this.isImageMenu = isImageMenu;
	}
	public List<PhotographDetail> getPhotographDetailList() {
		return photographDetailList;
	}
	public void setPhotographDetailList(List<PhotographDetail> photographDetailList) {
		this.photographDetailList = photographDetailList;
	}
	public List<CategoryDetail> getCategoryDetailList() {
		return categoryDetailList;
	}
	public void setCategoryDetailList(List<CategoryDetail> categoryDetailList) {
		this.categoryDetailList = categoryDetailList;
	}
}
