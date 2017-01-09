package com.fv.repository.domain;
import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * Created by ishu on 19/02/16.
 */
@DynamoDBTable(tableName = "RestaurantFeedDetails")
public class RestaurantFeedbackEO {

	private String createdTimestamp;
	private String updatedTimestmp;
	private BigDecimal restId;
	private BigDecimal totalSumRatings;
	private int totalSumRcmdBy;
	private int visitCount;
    
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
    @DynamoDBHashKey(attributeName = "restId")
    public BigDecimal getRestId() {
        return restId;
    }
    public void setRestId(BigDecimal restId) {
        this.restId = restId;
    }
    @DynamoDBAttribute(attributeName = "sumRatings")
    public BigDecimal getTotalSumRatings() {
        return totalSumRatings;
    }
    public void setTotalSumRatings(BigDecimal totalSumRatings) {
        this.totalSumRatings = totalSumRatings;
    }
    @DynamoDBAttribute(attributeName = "rcmdTotal")
    public int getTotalSumRcmdBy() {
        return totalSumRcmdBy;
    }
    public void setTotalSumRcmdBy(int totalSumRcmdBy) {
        this.totalSumRcmdBy = totalSumRcmdBy;
    }
    @DynamoDBAttribute(attributeName = "visits")
    public int getVisitCount() {
        return visitCount;
    }
    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}
