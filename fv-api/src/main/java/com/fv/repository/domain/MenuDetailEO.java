package com.fv.repository.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ishu on 12/02/16.
 */
@DynamoDBTable(tableName = "MainRestaurantMenuDetails")
public class MenuDetailEO implements Serializable {

	private static final long serialVersionUID = 8403271143960163130L;

	private long menuId;
	private List<Integer> categories;
	private long restId;
	private String createdTimestamp;
	private String updatedTimestmp;

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
	@DynamoDBHashKey(attributeName = "menuId")
	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	@DynamoDBAttribute(attributeName = "categories")
	public List<Integer> getCategories() {
		return categories;
	}
	public void setCategories(List<Integer> categories) {
		this.categories = categories;
	}
	@DynamoDBAttribute(attributeName = "restId")
	public long getRestId() {
		return restId;
	}
	public void setRestId(long restId) {
		this.restId = restId;
	}
}
