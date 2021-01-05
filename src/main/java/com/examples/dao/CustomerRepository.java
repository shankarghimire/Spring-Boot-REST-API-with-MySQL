package com.examples.dao;

import org.springframework.data.repository.CrudRepository;

import com.examples.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
