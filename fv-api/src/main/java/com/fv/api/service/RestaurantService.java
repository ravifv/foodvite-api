package com.fv.api.service;

import com.fv.api.dto.MenuDetail;
import com.fv.api.dto.MenuDetailRequest;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.dto.RestaurantDetailRequest;
import com.fv.common.util.Either;

public interface RestaurantService {

	Either<MenuDetail> getRestaurantMenuDetail(MenuDetailRequest menuDetailRequest);
	Either<RestaurantDetail> retrieveRestaurantDetails(RestaurantDetailRequest restaurantDetailRequest);

}
