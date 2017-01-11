package com.fv.repository.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fv.api.dto.PhotographDetail;

import com.fv.repository.domain.RestaurantPhotoEO;

public interface RestaurantPhotoRepository extends CrudRepository<RestaurantPhotoEO, BigDecimal>{
	 RestaurantPhotoEO getEntity(BigDecimal restId);
	 void saveFSEntity(List<PhotographDetail> photosPOs,BigDecimal restId);
}
