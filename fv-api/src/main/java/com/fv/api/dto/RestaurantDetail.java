package com.fv.api.dto;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RestaurantDetail {
	
	private  List <PhotographDetail> photographs;
	private  int isTableReserve;
	private String restaurantId;
	private String restaurantName;
	private Boolean isFoodviteOnboarded;
	private LocationDetail locationDetail;
	private RestaurantFeedbackDetail restaurantFeedbackDetail;
	@SerializedName("restraImage")
	private String restaurantImage;
	private chope chope;
	private String placeId;

	public int getIsTableReserve() {
		return isTableReserve;
	}
	public void setIsTableReserve(int isTableReserve) {
		this.isTableReserve = isTableReserve;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public List<PhotographDetail> getPhotographs() {
		return photographs;
	}
	public void setPhotographs(List<PhotographDetail> photographs) {
		this.photographs = photographs;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Boolean getIsFoodviteOnboarded() {
		return isFoodviteOnboarded;
	}
	public void setIsFoodviteOnboarded(Boolean isFoodviteOnboarded) {
		this.isFoodviteOnboarded = isFoodviteOnboarded;
	}
	public LocationDetail getLocationDetail() {
		return locationDetail;
	}
	public void setLocationDetail(LocationDetail locationDetail) {
		this.locationDetail = locationDetail;
	}
	public RestaurantFeedbackDetail getRestaurantFeedbackDetail() {
		return restaurantFeedbackDetail;
	}
	public void setRestaurantFeedbackDetail(RestaurantFeedbackDetail restaurantFeedbackDetail) {
		this.restaurantFeedbackDetail = restaurantFeedbackDetail;
	}
	public String getRestaurantImage() {
		return restaurantImage;
	}
	public void setRestaurantImage(String restaurantImage) {
		this.restaurantImage = restaurantImage;
	}
	public chope getChope() {
		return chope;
	}
	public void setChope(chope chope) {
		this.chope = chope;
	}
	public static class chope{
		private String url;

		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}
}
