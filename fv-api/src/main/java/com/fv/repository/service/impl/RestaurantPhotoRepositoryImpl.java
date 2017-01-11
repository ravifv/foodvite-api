package com.fv.repository.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.fv.api.dto.PhotographDetail;
import com.fv.common.util.ImageUtil;
import com.fv.db.util.DynamoDBConnectionManager;
import com.fv.repository.domain.RestaurantPhotoEO;
import com.fv.repository.service.RestaurantPhotoRepository;


public class RestaurantPhotoRepositoryImpl implements RestaurantPhotoRepository{
	DynamoDBMapper mapper;
	 DynamoDB dynamoDB ;
	 public RestaurantPhotoRepositoryImpl() {
	        mapper = DynamoDBConnectionManager.getMapper();
	        dynamoDB = DynamoDBConnectionManager.getDynamoDB();
	    } 
	
	 Table restPhotosTable = dynamoDB.getTable("MainRestaurantPhotos");
	 
	public RestaurantPhotoEO getEntity(BigDecimal restId){
		RestaurantPhotoEO restaurantPhotoEO = new RestaurantPhotoEO();
		restaurantPhotoEO.setRestId(restId);
		restaurantPhotoEO = mapper.load(restaurantPhotoEO);
		return restaurantPhotoEO;
		
	}
	public void saveEntity(List<PhotographDetail> photosPOs,BigDecimal restId){

       Item photoItem = new Item().withPrimaryKey("restId", restId);

       for (int i = 0; i < photosPOs.size(); i++) {
       	PhotographDetail photoData = photosPOs.get(i);
       	
       	String s3Url = ImageUtil.storeRestPhoto(photoData.getPhotoImageUrl(),photoData.getHeight(),photoData.getWidth(),restId.toString());
       	
           photoItem = photoItem.withMap("photo" + String.valueOf(i+1), new ValueMap()
                   .withString("imgUrl", "".equalsIgnoreCase(s3Url)?"-":s3Url)
                   .withNumber("height" , photoData.getHeight())
                   .withNumber("width", photoData.getWidth()));
       }

       restPhotosTable.putItem(photoItem);
   	
   }
   
   public void saveFSEntity(List<PhotographDetail> photosPOs,BigDecimal restId){

       Item photoItem = new Item()
               .withPrimaryKey("restId", restId);

       for (int i = 0; i < photosPOs.size(); i++) {
       	PhotographDetail photoData = photosPOs.get(i);
       	
       //	String s3Url = ImageUtil.storeRestPhoto(photoData.getPhotoImageUrl(),photoData.getHeight(),photoData.getWidth(),restId.toString());
       	
           photoItem = photoItem.withMap("photo" + String.valueOf(i+1), new ValueMap()
                   .withString("imgUrl", photoData.getPhotoImageUrl())
                   .withNumber("height" , photoData.getHeight())
                   .withNumber("width", photoData.getWidth()));
       }

       restPhotosTable.putItem(photoItem);
   	
   
  
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
	public void delete(RestaurantPhotoEO arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends RestaurantPhotoEO> arg0) {
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
	public Iterable<RestaurantPhotoEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RestaurantPhotoEO> findAll(Iterable<BigDecimal> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestaurantPhotoEO findOne(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends RestaurantPhotoEO> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends RestaurantPhotoEO> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
