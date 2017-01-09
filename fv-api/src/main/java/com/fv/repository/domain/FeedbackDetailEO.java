package com.fv.repository.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by ishu on 19/02/16.
 */
@DynamoDBTable(tableName = "FeedbackDetails")
public class FeedbackDetailEO {

	private BigDecimal restId;
	private String customerId;
	private Date createdAt;
	private String comment;
	private BigDecimal rating;
	private String isRcmd;

	@DynamoDBHashKey(attributeName = "restId")
	public BigDecimal getRestId() {
		return restId;
	}
	public void setRestId(BigDecimal restId) {
		this.restId = restId;
	}
	@DynamoDBAttribute(attributeName = "customerId")
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@DynamoDBRangeKey(attributeName = "createdAt")
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@DynamoDBAttribute(attributeName = "comment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@DynamoDBAttribute(attributeName = "rating")
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	@DynamoDBAttribute(attributeName = "isRcmd")
	public String isRcmd() {
		return isRcmd;
	}
	public void setRcmd(String rcmd) {
		isRcmd = rcmd;
	}
}
