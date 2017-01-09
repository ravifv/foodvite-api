package com.fv.repository.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName = "SellerRegistrationDetails")
public class SellerDetailEO {

	private BigDecimal restId; 
	private String deviceToken;
	private String deviceType;
	private BigDecimal sellerId;
	private boolean activateFlag;
	private String address;
	private Date createdTimestamp;
	private String email;
	private String mobileNumber;
	private String name;
	private boolean orderFlag;
	private boolean parentFlag;
	private String password;
	private String updatedTimestamp;
	private String pinCode;
	private String contact;
	private boolean firstTime;

	@DynamoDBAttribute(attributeName = "deviceToken")
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	@DynamoDBAttribute(attributeName = "deviceType")
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	@DynamoDBHashKey(attributeName = "sellerId")
	public BigDecimal getSellerId() {
		return sellerId;
	}
	public void setSellerId(BigDecimal sellerId) {
		this.sellerId = sellerId;
	}
	@DynamoDBAttribute(attributeName = "restId")
	public BigDecimal getRestId() {
		return restId;
	}
	public void setRestId(BigDecimal restId) {
		this.restId = restId;
	}
	@DynamoDBAttribute(attributeName = "activateFlag")
	public boolean isActivateFlag() {
		return activateFlag;
	}
	public void setActivateFlag(boolean activateFlag) {
		this.activateFlag = activateFlag;
	}
	@DynamoDBAttribute(attributeName = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@DynamoDBAttribute(attributeName = "createdTimestamp")
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	@DynamoDBAttribute(attributeName = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@DynamoDBAttribute(attributeName = "mobileNumber")
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@DynamoDBAttribute(attributeName = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@DynamoDBAttribute(attributeName = "orderFlag")
	public boolean isOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(boolean orderFlag) {
		this.orderFlag = orderFlag;
	}
	@DynamoDBAttribute(attributeName = "parentFlag")
	public boolean isParentFlag() {
		return parentFlag;
	}
	public void setParentFlag(boolean parentFlag) {
		this.parentFlag = parentFlag;
	}
	@DynamoDBAttribute(attributeName = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@DynamoDBAttribute(attributeName = "updatedTimestamp")
	public String getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(String updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	@DynamoDBAttribute(attributeName = "pinCode")
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getPinCode() {
		return pinCode;
	}
	@DynamoDBAttribute(attributeName = "contact")
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContact() {
		return contact;
	}
	@DynamoDBAttribute(attributeName = "firstTime")
	public void setFirstTime(boolean firstTime) {
		this.firstTime = firstTime;
	}
	public boolean isFirstTime() {
		return firstTime;
	}

	@Override
	public String toString() {
		return "SellerRegistrationDetailsEntity{" +
				"sellerId=" + sellerId +
				", activateFlag=" + activateFlag +
				", address='" + address + '\'' +
				", createdTimestamp=" + createdTimestamp +
				", email='" + email + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", name='" + name + '\'' +
				", orderFlag=" + orderFlag +
				", parentFlag=" + parentFlag +
				", password='" + password + '\'' +
				", updatedTimestamp='" + updatedTimestamp + '\'' +
				", pinCode='" + pinCode + '\'' +
				", contact='" + contact + '\'' +
				", firstTime='" + firstTime + '\'' +
				'}';
	}

}
