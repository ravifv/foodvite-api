package com.fv.api.service;

import com.fv.api.dto.LoginRequest;
import com.fv.api.dto.RestaurantDetail;
import com.fv.common.util.Either;
import com.fv.common.util.Errors;
import com.fv.repository.domain.CustomerRegistrationEO;

public interface SecurityService {

	public Either<RestaurantDetail> getLoginDetail(LoginRequest loginRequest, Errors errors);

	Either<CustomerRegistrationEO> getUserDetailsByApiKey(String apiKey, Errors errors);

}
