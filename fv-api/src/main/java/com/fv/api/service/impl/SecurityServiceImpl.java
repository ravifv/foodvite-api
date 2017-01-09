package com.fv.api.service.impl;

import org.springframework.stereotype.Service;

import com.fv.api.dto.LoginRequest;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.service.SecurityService;
import com.fv.common.util.Either;
import com.fv.common.util.Errors;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Override
	public Either<RestaurantDetail> getLoginDetail(LoginRequest loginRequest, Errors errors) {
		
		return null;
	}

}
