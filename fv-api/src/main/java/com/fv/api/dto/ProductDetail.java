package com.fv.api.dto;

import java.math.BigDecimal;

public class ProductDetail {
	
    private BigDecimal productId;
    private String productName;
    private String imageUrl;
    private String productDescription;
    private Double sellingPrice;
    
    public ProductDetail(BigDecimal productId, String productName, String imageUrl, String productDescription, Double sellingPrice) {
        this.productId = productId;
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.productDescription = productDescription;
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getProductId() {
        return productId;
    }

    public void setProductId(BigDecimal productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
