package com.fv.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fv.api.constant.HttpConstant;
import com.fv.api.constant.URIConstant;
import com.fv.api.dto.MenuDetail;
import com.fv.api.dto.MenuDetailRequest;
import com.fv.api.service.RestaurantService;
import com.fv.common.util.Either;

import io.swagger.annotations.Api;

/**
 * 
 * @author Ravi Chauhan
 *
 */
@Controller
@Api(value = HttpConstant.NAVIGATION_API, basePath=URIConstant.NAVIGATION_API_BASE, 
produces=HttpConstant.PRODUCES_JSON, consumes=HttpConstant.CONSUMES_JSON, position=1)
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value = URIConstant.MENU_LIST, method = RequestMethod.POST)
	public @ResponseBody Either<MenuDetail> getMenuDetail(@RequestBody MenuDetailRequest menuDetailRequest) {
		Either<MenuDetail> menuDetailEither = restaurantService.getRestaurantMenuDetail(menuDetailRequest);
		return menuDetailEither;
	}

}
