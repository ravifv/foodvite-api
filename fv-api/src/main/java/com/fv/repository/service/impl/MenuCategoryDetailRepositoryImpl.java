package com.fv.repository.service.impl;

import java.math.BigDecimal;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fv.db.util.DynamoDBConnectionManager;
import com.fv.repository.domain.MenuCategoryDetailEO;
import com.fv.repository.service.MenuCategoryDetailRepository;

public class MenuCategoryDetailRepositoryImpl implements MenuCategoryDetailRepository{
	public MenuCategoryDetailRepositoryImpl() {
        mapper = DynamoDBConnectionManager.getMapper();
        dynamoDB = DynamoDBConnectionManager.getDynamoDB();
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
	public void delete(MenuCategoryDetailEO arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends MenuCategoryDetailEO> arg0) {
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
	public Iterable<MenuCategoryDetailEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<MenuCategoryDetailEO> findAll(Iterable<BigDecimal> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuCategoryDetailEO findOne(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MenuCategoryDetailEO> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends MenuCategoryDetailEO> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	DynamoDBMapper mapper;
	 DynamoDB dynamoDB ;
	
	 @Override
	public MenuCategoryDetailEO getCategoryProductsItems(BigDecimal categoryId) {
		 MenuCategoryDetailEO menuCategoryDetailEO = new MenuCategoryDetailEO();
		 menuCategoryDetailEO.setCategoryId(categoryId.longValueExact());
		 menuCategoryDetailEO = mapper.load(menuCategoryDetailEO);
	    	
	    	return menuCategoryDetailEO;
	    }
	
	
}
