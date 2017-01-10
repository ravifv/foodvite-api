package com.fv.api.dto;

import java.util.List;

public class MenuDetail {

    private boolean isSuccess;
    private String resultCode;
    private String restaurantName;
    private String title; 
    private String message;
    private boolean isImageMenu;
    private List<PhotographDetail> photographDetailList;
    private List<CategoryDetail> categoryDetailList;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
