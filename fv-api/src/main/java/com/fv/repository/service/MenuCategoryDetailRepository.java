package com.fv.repository.service;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.fv.repository.domain.MenuCategoryDetailEO;

public interface MenuCategoryDetailRepository  extends CrudRepository<MenuCategoryDetailEO, BigDecimal>{
	
	MenuCategoryDetailEO getCategoryProductsItems(BigDecimal categoryId);
}
