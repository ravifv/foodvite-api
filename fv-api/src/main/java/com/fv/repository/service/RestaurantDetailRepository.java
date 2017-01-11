package com.fv.repository.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.fv.repository.domain.RestaurantDetailEO;

public interface RestaurantDetailRepository extends CrudRepository<RestaurantDetailEO, BigDecimal>{
	 void saveSeller(RestaurantDetailEO sellerEntity);
	 RestaurantDetailEO getSeller(BigDecimal restId);
	   List<BigDecimal> getCategoryList(BigDecimal restId);
}
