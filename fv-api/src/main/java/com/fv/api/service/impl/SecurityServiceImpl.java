package com.fv.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fv.api.dto.LoginRequest;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.service.SecurityService;
import com.fv.common.util.Either;
import com.fv.common.util.Errors;
import com.fv.repository.domain.CustomerRegistrationEO;
import com.fv.repository.service.CustomerRegistrationRepository;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	CustomerRegistrationRepository customerRegistrationRepository;
	
	@Override
	public Either<RestaurantDetail> getLoginDetail(LoginRequest loginRequest, Errors errors) {
		
		return null;
	}

	@Override
	public Either<CustomerRegistrationEO> getUserDetailsByApiKey(String apiKey, Errors errors){
		CustomerRegistrationEO customerRegistrationObject = customerRegistrationRepository.findByApiKey(apiKey);
		if(null == customerRegistrationObject){
			//TODO throw error
		}
		return Either.buildEntity(customerRegistrationObject);
	}
}
