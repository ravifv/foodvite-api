package com.fv.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fv.api.constant.HttpConstant;
import com.fv.api.constant.URIConstant;

import io.swagger.annotations.Api;

/**
 * 
 * @author Ravi Chauhan
 *
 */
@Controller
@Api(value = HttpConstant.PRODUCT_API, basePath=URIConstant.PRODUCT_API_BASE, 
produces=HttpConstant.PRODUCES_JSON, consumes=HttpConstant.CONSUMES_JSON, position=1)
public class ProductController {

	@RequestMapping(value = URIConstant.RESTAURANTS_LIST, method = RequestMethod.GET)
	public @ResponseBody String getRestaurantList(){
		return null;
	}
}
