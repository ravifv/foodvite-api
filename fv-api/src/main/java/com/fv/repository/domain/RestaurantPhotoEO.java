package com.fv.repository.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

//TODO: Why are we classifying the Photographs based on restaurants ?? 
//It must a generic Entity keeping all the records of photographs of user or restaurants 
public class RestaurantPhotoEO {
	
	String restId;
	String createdTimestamp;
	String updatedTimestmp;
	
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

}
