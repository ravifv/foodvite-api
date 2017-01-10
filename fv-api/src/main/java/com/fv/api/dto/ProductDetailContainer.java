package com.fv.api.dto;

import java.util.List;

public class ProductDetailContainer {
    private boolean hasMoreProducts;
    private int page;
    private List<ProductDetail> productDetailList;
    
	public boolean isHasMoreProducts() {
		return hasMoreProducts;
	}
	public void setHasMoreProducts(boolean hasMoreProducts) {
		this.hasMoreProducts = hasMoreProducts;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<ProductDetail> getProductDetailList() {
		return productDetailList;
	}
	public void setProductDetailList(List<ProductDetail> productDetailList) {
		this.productDetailList = productDetailList;
	}

   
}
