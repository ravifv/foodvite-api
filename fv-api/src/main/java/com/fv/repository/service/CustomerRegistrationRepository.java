package com.fv.repository.service;

import org.springframework.data.repository.CrudRepository;

import com.fv.repository.domain.CustomerRegistrationEO;

public interface CustomerRegistrationRepository extends CrudRepository<CustomerRegistrationEO, String>{

}
