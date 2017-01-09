package com.fv.repository.domain;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by ishu on 12/02/16.
 */
@DynamoDBTable(tableName = "MainMenuCategoryDetails")
public class MenuCategoryDetailEO implements Serializable{

    private static final long serialVersionUID = 8237037597542500382L;
    //TODO: Why the fields are not well define ?
    
    private long categoryId;
    private String categoryName;
    private List<Integer> productId;
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
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Integer> getProductId() {
		return productId;
	}
	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}
	
}
