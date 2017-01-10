package com.fv.api.dto;

import java.math.BigDecimal;

public class CategoryDetail {
	private BigDecimal categoryId;
    private String categoryName;
    private ProductDetailContainer productDetailContainer;
    
	public BigDecimal getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(BigDecimal categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public ProductDetailContainer getProductDetailContainer() {
		return productDetailContainer;
	}
	public void setProductDetailContainer(ProductDetailContainer productDetailContainer) {
		this.productDetailContainer = productDetailContainer;
	}

}
