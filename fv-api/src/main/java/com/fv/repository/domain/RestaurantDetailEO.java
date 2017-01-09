package com.fv.repository.domain;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="MainRestaurantDetails")
public class RestaurantDetailEO {

	private String createdTimestamp;
	private String updatedTimestmp;
	private int isTableReserve;
	private String reserveURL;
	private String restName;
	private BigDecimal restId;
	private String address;
	private String latitude;
	private String longitude;
	private String pincode;
	private BigDecimal minimumValue;
	private int isSponsored;
	private String location;
	private float ratings;
	private int isOnFV;
	private boolean isGstApplicable;
	private int gstApplicable;
	private int visits;
	private String placeId;
	
	@DynamoDBAttribute(attributeName="createdTimestamp")  
	public String getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	@DynamoDBAttribute(attributeName="updatedTimestmp")  
	public String getUpdatedTimestmp() {
		return updatedTimestmp;
	}
	public void setUpdatedTimestmp(String updatedTimestmp) {
		this.updatedTimestmp = updatedTimestmp;
	}
	@DynamoDBAttribute(attributeName="isTableReserve")  
	public int getIsTableReserve() {
		return isTableReserve;
	}
	public void setIsTableReserve(int isTableReserve) {
		this.isTableReserve = isTableReserve;
	}
	@DynamoDBAttribute(attributeName="reserveURL")  
	public String getReserveURL() {
		return reserveURL;
	}
	public void setReserveURL(String reserveURL) {
		this.reserveURL = reserveURL;
	}
	@DynamoDBAttribute(attributeName="ratings")  
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	@DynamoDBAttribute(attributeName="visits")  
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	@DynamoDBAttribute(attributeName="location")  
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getIsSponsored() {
		return isSponsored;
	}
	public void setIsSponsored(int isSponsored) {
		this.isSponsored = isSponsored;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public BigDecimal getMinimumValue() {
		return minimumValue;
	}
	public void setMinimumValue(BigDecimal minimumValue) {
		this.minimumValue = minimumValue;
	}
	public int getGstApplicable() {
		return gstApplicable;
	}
	public void setGstApplicable(int gstApplicable) {
		this.gstApplicable = gstApplicable;
	}
	@DynamoDBAttribute(attributeName="restName")  
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	@DynamoDBHashKey(attributeName="restId")
	public BigDecimal getRestId() {
		return restId;
	}
	public void setRestId(BigDecimal restId) {
		this.restId = restId;
	}
	@DynamoDBAttribute(attributeName="address")  
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@DynamoDBAttribute(attributeName="latitude")  
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@DynamoDBAttribute(attributeName="longitude")  
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@DynamoDBAttribute(attributeName="pincode")  
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@DynamoDBAttribute(attributeName="isOnFV")  
	public int isOnFV() {
		return isOnFV;
	}
	public void setOnFV(int isOnFV) {
		this.isOnFV = isOnFV;
	}
	public boolean isGstApplicable() {
		return isGstApplicable;
	}
	public void setGstApplicable(boolean gstApplicable) {
		isGstApplicable = gstApplicable;
	}
}
