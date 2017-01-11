package com.fv.repository.service.impl;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.fv.db.util.DynamoDBConnectionManager;
import com.fv.repository.domain.ProductDetailEO;
import com.fv.repository.service.ProductDetailRepository;

public class ProductDetailRepositoryImpl implements ProductDetailRepository{
	DynamoDBMapper mapper;
	
	 public ProductDetailRepositoryImpl() {
	        mapper = DynamoDBConnectionManager.getMapper();
	       
	    }
	 @Override
		public ProductDetailEO getProductDetail(BigDecimal productId) {
			ProductDetailEO productDetailEO = new ProductDetailEO();
			productDetailEO.setProductId(productId);
			productDetailEO = mapper.load(productDetailEO);
			return productDetailEO;
		}
	 
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(BigDecimal arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProductDetailEO arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends ProductDetailEO> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ProductDetailEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ProductDetailEO> findAll(Iterable<BigDecimal> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDetailEO findOne(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductDetailEO> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ProductDetailEO> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	 

	
	
}
