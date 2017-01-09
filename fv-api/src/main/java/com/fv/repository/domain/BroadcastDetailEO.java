package com.fv.repository.domain;

import java.math.BigDecimal;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "BroadcastsDetails")
public class BroadcastDetailEO {

	private BigDecimal inviteId;
	private String inviteeId;
	private String receiverName;
	private BigDecimal selectedRestraId;
	private String customerId;
	private String imageUrl;
	private String inviteeName;
	private int lastResponse;
	private String restaurantJoinTime;
	private String restaurantName;
	private String createdTimestamp;
	private Set<String> invitedBuddiesList;	
	private String updatedTimestamp;
	private Set<String> buddiesList;
	private Set<String> joined;
	private boolean isOwner;
	private Set<String> skiped;
	private Set<String> ordered;
	private boolean isOnFv;


	@DynamoDBRangeKey(attributeName="inviteId")  
	public BigDecimal getInviteId() {
		return inviteId;
	}
	public String getInviteeId() {
		return inviteeId;
	}
	@DynamoDBAttribute(attributeName="receiverName")  
	public String getReceiverName() {
		return receiverName;
	}
	public void setInviteeId(String inviteeId) {
		this.inviteeId = inviteeId;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setInviteId(BigDecimal inviteId) {
		this.inviteId = inviteId;
	}
	@DynamoDBHashKey(attributeName="customerId")  
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@DynamoDBAttribute(attributeName="imageUrl")  
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@DynamoDBAttribute(attributeName="inviteeName")  
	public String getInviteeName() {
		return inviteeName;
	}
	public void setInviteeName(String inviteeName) {
		this.inviteeName = inviteeName;
	}
	@DynamoDBAttribute(attributeName="lastResponse")  
	public int getLastResponse() {
		return lastResponse;
	}
	public void setLastResponse(int lastResponse) {
		this.lastResponse = lastResponse;
	}
	@DynamoDBAttribute(attributeName="restaurantJoinTime")  
	public String getRestaurantJoinTime() {
		return restaurantJoinTime;
	}
	public void setRestaurantJoinTime(String restaurantJoinTime) {
		this.restaurantJoinTime = restaurantJoinTime;
	}
	@DynamoDBAttribute(attributeName="restaurantName")  
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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
	@DynamoDBAttribute(attributeName="invited") 
	public Set<String> getInvitedBuddiesList() {
		return invitedBuddiesList;
	}
	public void setInvitedBuddiesList(Set<String> invitedBuddiesList) {
		this.invitedBuddiesList = invitedBuddiesList;
	}
	@DynamoDBAttribute(attributeName="notResponded")  
	public Set<String> getBuddiesList() {
		return buddiesList;
	}
	public void setBuddiesList(Set<String> buddiesList) {
		this.buddiesList = buddiesList;
	}
	@DynamoDBAttribute(attributeName="isOnFv")  
	public boolean isOnFv() {
		return isOnFv;
	}
	public void setOnFv(boolean isOnFv) {
		this.isOnFv = isOnFv;
	}
	@DynamoDBAttribute(attributeName="selectedRestraId")  
	public BigDecimal getSelectedRestraId() {
		return selectedRestraId;
	}
	public void setSelectedRestraId(BigDecimal selectedRestraId) {
		this.selectedRestraId = selectedRestraId;
	}
	@DynamoDBAttribute(attributeName="isOwner")  
	public boolean isOwner() {
		return isOwner;
	}
	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}
	@DynamoDBAttribute(attributeName="joined")  
	public Set<String> getJoined() {
		return joined;
	}
	public void setJoined(Set<String> joined) {
		this.joined = joined;
	}
	@DynamoDBAttribute(attributeName="skiped")  
	public Set<String> getSkiped() {
		return skiped;
	}

	public void setSkiped(Set<String> skiped) {
		this.skiped = skiped;
	}
	@DynamoDBAttribute(attributeName="ordered")  
	public Set<String> getOrdered() {
		return ordered;
	}
	public void setOrdered(Set<String> ordered) {
		this.ordered = ordered;
	}
}
