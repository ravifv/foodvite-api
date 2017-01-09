package com.fv.repository.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName = "CustomerDetails")
public class CustomerDetailEO implements Serializable {

	private static final long serialVersionUID = -7667045171037620226L;//Why is this inconsistency ?

	private  int loginType;
	private String link;
	private String gender;
	private String age;
	private String dob;
	private String customerId;
	private String apiKey;
	private Set<BigDecimal> orderList;
	private Set<String> contactList;
	private String mobileNumber;
	private String deviceType;
	private String name;
	private String profilePic;
	private String emailId;
	private String password;
	private String deviceToken;
	private String systemPaswd;
	private String signUplatitude;
	private String signUpLongitude;
	private String createdTimestamp;
	private String updatedTimestamp;
	private Set<BigDecimal> groups;
	private Set<BigDecimal> invites;

	@DynamoDBAttribute(attributeName = "link")
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@DynamoDBAttribute(attributeName = "gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@DynamoDBAttribute(attributeName = "age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@DynamoDBAttribute(attributeName = "dob")
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@DynamoDBAttribute(attributeName = "contacts")
	public Set<String> getContactList() {
		return contactList;
	}
	public void setContactList(Set<String> contactList) {
		this.contactList = contactList;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Set<BigDecimal> getGroups() {
		return groups;
	}
	public void setGroups(Set<BigDecimal> groups) {
		this.groups = groups;
	}
	@DynamoDBAttribute(attributeName = "deviceType")
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	@DynamoDBAttribute(attributeName = "loginType")
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	@DynamoDBHashKey(attributeName = "customerId")
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@DynamoDBAttribute(attributeName = "apiKey")
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	@DynamoDBAttribute(attributeName = "orders")
	public Set<BigDecimal> getOrderList() {
		return orderList;
	}
	public void setOrderList(Set<BigDecimal> orderList) {
		this.orderList = orderList;
	}
	@DynamoDBAttribute(attributeName="invites") 
	public Set<BigDecimal> getInvites() {
		return invites;
	}

	public void setInvites(Set<BigDecimal> invites) {
		this.invites = invites;
	}

	@DynamoDBAttribute(attributeName="deviceToken")
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	@DynamoDBAttribute(attributeName="groups") 
	public Set<BigDecimal> getGroupsList() {
		return groups;
	}
	public void setGroupsList(Set<BigDecimal> groups) {
		this.groups = groups;
	}
	@DynamoDBAttribute(attributeName="systemPaswd") 
	public String getSystemPaswd() {
		return systemPaswd;
	}
	public void setSystemPaswd(String systemPaswd) {
		this.systemPaswd = systemPaswd;
	}
	@DynamoDBAttribute(attributeName="signUplatitude") 
	public String getSignUplatitude() {
		return signUplatitude;
	}
	public void setSignUplatitude(String signUplatitude) {
		this.signUplatitude = signUplatitude;
	}
	@DynamoDBAttribute(attributeName="signUpLongitude") 
	public String getSignUpLongitude() {
		return signUpLongitude;
	}
	public void setSignUpLongitude(String signUpLongitude) {
		this.signUpLongitude = signUpLongitude;
	}
	@DynamoDBAttribute(attributeName="createdTimestamp") 
	public String getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	@DynamoDBAttribute(attributeName="updatedTimestamp") 
	public String getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(String updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	@DynamoDBAttribute(attributeName="password") 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@DynamoDBAttribute(attributeName="name")  
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name; 
	}
	@DynamoDBAttribute(attributeName="profilePic")  
	public String getProfilePic() {
		return profilePic; 
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic; 
	}

	@DynamoDBAttribute(attributeName="emailId")  
	public String getEmail() {
		return emailId;
	}
	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "CustomerEntity{" +
				"customerId='" + customerId + '\'' +
				", apiKey='" + apiKey + '\'' +
				", orderList=" + orderList +
				'}';
	}
}

