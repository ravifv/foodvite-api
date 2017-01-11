package com.fv.repository.service;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.fv.repository.domain.ProductDetailEO;

public interface ProductDetailRepository extends CrudRepository<ProductDetailEO, BigDecimal>{

	ProductDetailEO getProductDetail(BigDecimal productId) ;
    
}
