package com.fv.repository.domain;



import java.math.BigDecimal;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="GroupDetails")
public class GroupDetailEO {

	private String groupName;
	private String groupProfilePicURL;
	private Set<String> buddiesList;
	private String createdTimestamp;
	private String updatedTimestamp;
	private BigDecimal groupId;

	@DynamoDBAttribute(attributeName="buddiesList") 
	public Set<String> getBuddiesList() {
		return buddiesList;
	}
	public void setBuddiesList(Set<String> buddiesList) {
		this.buddiesList = buddiesList;
	}
	@DynamoDBHashKey(attributeName="groupId") 
	public BigDecimal getGroupID() {
		return groupId;
	}
	public void setGroupID(BigDecimal groupId) {
		this.groupId = groupId;
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
	@DynamoDBAttribute(attributeName="groupName") 
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@DynamoDBAttribute(attributeName="groupPicUrl") 
	public String getGroupProfilePicURL() {
		return groupProfilePicURL;
	}
	public void setGroupProfilePicURL(String groupProfilePicURL) {
		this.groupProfilePicURL = groupProfilePicURL;
	}
}
