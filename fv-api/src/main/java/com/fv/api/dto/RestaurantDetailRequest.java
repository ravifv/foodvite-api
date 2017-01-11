package com.fv.api.dto;

public class RestaurantDetailRequest extends Request{
	
	String latitude;
	String longitude ;
    int distance;
    String searchText;
    String bottomCount;
    
    public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getBottomCount() {
		return bottomCount;
	}
	public void setBottomCount(String bottomCount) {
		this.bottomCount = bottomCount;
	}
	
}
