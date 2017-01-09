package com.fv.repository.service;

import org.springframework.data.repository.CrudRepository;

import com.fv.repository.domain.CustomerDetailEO;

public interface CustomerDetailRepository extends CrudRepository<CustomerDetailEO, String>{

}
