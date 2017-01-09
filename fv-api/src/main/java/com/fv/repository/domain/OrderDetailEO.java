package com.fv.repository.domain;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
@DynamoDBTable(tableName = "OrderDetails")
public class OrderDetailEO {

	private String name;
	private String price;
	private BigDecimal orderItemId;
	private BigDecimal productId;
	private int quantity;
	private String unitPrice;
	private BigDecimal totalValue;
	private BigDecimal netPayable;
	private BigDecimal taxValue;
	private BigDecimal discount;

	@DynamoDBAttribute(attributeName = "productName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@DynamoDBAttribute(attributeName = "productPrice")
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@DynamoDBAttribute(attributeName = "totalValue")
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	@DynamoDBAttribute(attributeName = "netPayable")
	public BigDecimal getNetPayable() {
		return netPayable;
	}
	public void setNetPayable(BigDecimal netPayable) {
		this.netPayable = netPayable;
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
	@DynamoDBHashKey(attributeName = "orderItemId")
	public BigDecimal getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(BigDecimal orderItemId) {
		this.orderItemId = orderItemId;
	}
	@DynamoDBAttribute(attributeName = "productId")
	public BigDecimal getProductId() {
		return productId;
	}
	public void setProductId(BigDecimal productId) {
		this.productId = productId;
	}
	@DynamoDBAttribute(attributeName = "quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "OrderDetailsEntity{" +
				"orderItemId=" + orderItemId +
				", productId=" + productId +
				", quantity=" + quantity +
				", unitPrice=" + unitPrice +
				'}';
	}
}
