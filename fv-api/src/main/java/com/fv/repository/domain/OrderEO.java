package com.fv.repository.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName = "Orders")
public class OrderEO {

	private BigDecimal netValue;
	private BigDecimal taxValue;
	private BigDecimal discount;
	private String chargeId;
	private int noOfItems;
	private String receiverCustomerId;
	private String senderCustomerId;
	private int isTableReserveOrder;
	private String cardId;
	private String joinTime;
	private BigDecimal orderId;
	private String status;
	private int isCancelled;
	private String createdTimeStamp;
	private String updatedTimestamp;
	private List<BigDecimal> orderItemList;
	private BigDecimal inviteId;
	private BigDecimal totalValue;
	private BigDecimal restId;
	private String restName;
	private Date createdSTimestamp;
	private String isFeedback;

	@DynamoDBAttribute(attributeName = "chargeId")
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	@DynamoDBAttribute(attributeName = "cardId")
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	@DynamoDBAttribute(attributeName = "joinTime")
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	@DynamoDBAttribute(attributeName = "isTableReserveOrder")
	public int getIsTableReserveOrder() {
		return isTableReserveOrder;
	}
	public void setIsTableReserveOrder(int isTableReserveOrder) {
		this.isTableReserveOrder = isTableReserveOrder;
	}
	@DynamoDBAttribute(attributeName = "createdSTimestamp")
	public Date getCreatedSTimestamp() {
		return createdSTimestamp;
	}
	public void setCreatedSTimestamp(Date createdSTimestamp) {
		this.createdSTimestamp = createdSTimestamp;
	}
	public int getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(int isCancelled) {
		this.isCancelled = isCancelled;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	@DynamoDBAttribute(attributeName = "isFeedback")
	public String getIsFeedback() {
		return isFeedback;
	}
	public void setIsFeedback(String isFeedback) {
		this.isFeedback = isFeedback;
	}
	@DynamoDBAttribute(attributeName = "restId")
	public BigDecimal getRestId() {
		return restId;
	}
	public void setRestId(BigDecimal restId) {
		this.restId = restId;
	}
	@DynamoDBAttribute(attributeName = "updatedTimestamp")
	public String getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(String updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	@DynamoDBAttribute(attributeName = "totalValue")
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	@DynamoDBAttribute(attributeName = "netValue")
	public BigDecimal getNetValue() {
		return netValue;
	}
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}
	@DynamoDBAttribute(attributeName = "taxValue")
	public BigDecimal getTaxValue() {
		return taxValue;
	}
	public void setTaxValue(BigDecimal taxValue) {
		this.taxValue = taxValue;
	}
	@DynamoDBAttribute(attributeName = "discount")
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	@DynamoDBAttribute(attributeName = "noOfItems")
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	@DynamoDBAttribute(attributeName = "receiverCustomerId")
	public String getReceiverCustomerId() {
		return receiverCustomerId;
	}
	public void setReceiverCustomerId(String receiverCustomerId) {
		this.receiverCustomerId = receiverCustomerId;
	}
	@DynamoDBAttribute(attributeName = "senderCustomerId")
	public String getSenderCustomerId() {
		return senderCustomerId;
	}
	public void setSenderCustomerId(String senderCustomerId) {
		this.senderCustomerId = senderCustomerId;
	}
	public BigDecimal getInviteId() {
		return inviteId;
	}
	public void setInviteId(BigDecimal inviteId) {
		this.inviteId = inviteId;
	}
	@DynamoDBHashKey(attributeName = "orderId")
	public BigDecimal getOrderId() {
		return orderId;
	}
	public void setOrderId(BigDecimal orderId) {
		this.orderId = orderId;
	}
	@DynamoDBAttribute(attributeName = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@DynamoDBAttribute(attributeName = "createdTimestamp")
	public String getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(String createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	@DynamoDBAttribute(attributeName = "orderItemList")
	public List<BigDecimal> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<BigDecimal> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "OrderEntity{" +
				"orderItemList=" + orderItemList +
				", createdTimeStamp='" + createdTimeStamp + '\'' +
				", status='" + status + '\'' +
				", orderId=" + orderId +
				'}';
	}
}
