package com.fv.repository.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.fv.db.util.DynamoDBConnectionManager;
import com.fv.repository.domain.RestaurantDetailEO;
import com.fv.repository.service.RestaurantDetailRepository;


public  class RestaurantDetailRepositoryImpl implements RestaurantDetailRepository {
	
	DynamoDBMapper mapper;
	 DynamoDB dynamoDB ;
	 

	public RestaurantDetailRepositoryImpl() {
	       mapper = DynamoDBConnectionManager.getMapper();
	       dynamoDB = DynamoDBConnectionManager.getDynamoDB();
	   }
		 
	@Override
	public void saveSeller(RestaurantDetailEO sellerEntity){
	   
	   mapper.save(sellerEntity);
	}
	@Override
	public RestaurantDetailEO getSeller(BigDecimal restId) {
		RestaurantDetailEO restaurantDetailEO = new RestaurantDetailEO();
		restaurantDetailEO.setRestId(restId);
   	
   		return mapper.load(restaurantDetailEO);
	}
	 @Override 
	//get all category from restMenyDetails
	 public List<BigDecimal> getCategoryList(BigDecimal restId) {
		  boolean isImageMenu=false;
	   	Table menuDetailsTable = dynamoDB.getTable("MainRestaurantMenuDetails");
	       HashMap<String, Object> valueMap = new HashMap<String, Object>();
	       valueMap.put(":restId", restId);
	
	       ScanSpec scanSpec = new ScanSpec()
	               .withFilterExpression("#restId = :restId")
	               .withNameMap(new NameMap().with("#restId", "restId"))
	               .withValueMap(valueMap);
	
	       try {
	           ItemCollection<ScanOutcome> scan = menuDetailsTable.scan(scanSpec);
	           IteratorSupport<Item, ScanOutcome> iterator = scan.iterator();
	           if (iterator.hasNext()) {
	               Item next = iterator.next();
	               List<BigDecimal> categories = next.getList("categories");
	               isImageMenu = next.getNumber("isImageMenu").equals(new BigDecimal(0))?false :true;
	               return categories;
	           }
	       } catch (Exception e) {
	           System.err.println("error in fetching ");
	         e.printStackTrace();
	       }
	       return Collections.EMPTY_LIST;
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
	public void delete(RestaurantDetailEO arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends RestaurantDetailEO> arg0) {
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
	public Iterable<RestaurantDetailEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RestaurantDetailEO> findAll(Iterable<BigDecimal> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantDetailEO findOne(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends RestaurantDetailEO> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends RestaurantDetailEO> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
