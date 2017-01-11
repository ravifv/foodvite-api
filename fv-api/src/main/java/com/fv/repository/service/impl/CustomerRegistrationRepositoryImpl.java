package com.fv.repository.service.impl;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.fv.db.util.*;
import com.fv.repository.domain.CustomerRegistrationEO;
import com.fv.repository.service.CustomerRegistrationRepository;

public class CustomerRegistrationRepositoryImpl implements CustomerRegistrationRepository {
	DynamoDBMapper mapper;

    public CustomerRegistrationRepositoryImpl() {
        mapper = DynamoDBConnectionManager.getMapper();
    }
	@Override
	public CustomerRegistrationEO findByApiKey(String apiKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerRegistrationEO imRetrieveRegistrationDetails(String apiKey) {
		CustomerRegistrationEO userRegistrationPOImpl = new CustomerRegistrationEO();
		userRegistrationPOImpl.setApikey(apiKey);
		userRegistrationPOImpl = mapper.load(userRegistrationPOImpl);
		return userRegistrationPOImpl;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CustomerRegistrationEO arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends CustomerRegistrationEO> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CustomerRegistrationEO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CustomerRegistrationEO> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerRegistrationEO findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerRegistrationEO> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends CustomerRegistrationEO> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
