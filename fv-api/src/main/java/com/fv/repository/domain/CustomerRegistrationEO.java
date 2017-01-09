package com.fv.repository.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="CustomerRegistration")
public class CustomerRegistrationEO {
	private int signUpType;
	private String mobileNumber;
	private String apiKey;
	private String countryCode;
	private String customerEmail;
	private String customerId;
	private String timestamp;
	private boolean isExpired;
	private   int isLogged;
	private String updatedTimestamp;

	@DynamoDBAttribute(attributeName="signUpType") 
	public int getSignUpType() {
		return signUpType;
	}
	public void setSignUpType(int signUpType) {
		this.signUpType = signUpType;
	}
	@DynamoDBAttribute(attributeName = "isLogged")
	public int getIsLogged() {
		return isLogged;
	}
	public void setIsLogged(int isLogged) {
		this.isLogged = isLogged;
	}
	@DynamoDBAttribute(attributeName="isExpired")  
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	@DynamoDBAttribute(attributeName="updatedTimestamp")  
	public String getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(String updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	@DynamoDBAttribute(attributeName="customerId")  
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@DynamoDBAttribute(attributeName="timestamp")  
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@DynamoDBHashKey(attributeName="apiKey")  
	public String getApikey() { 
		return apiKey; 
	}
	public void setApikey(String apiKey) {
		this.apiKey = apiKey; 
	}
	@DynamoDBAttribute(attributeName="emailId")  
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	@DynamoDBAttribute(attributeName="mobileNumber")  
	public String getMobileNumber() {
		return mobileNumber; 
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber; 
	}

	@DynamoDBAttribute(attributeName="countryCode")  
	public String getCountryCode() {
		return countryCode; 
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode; 
	}
}
