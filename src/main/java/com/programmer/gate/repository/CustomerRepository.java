package com.programmer.gate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.programmer.gate.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public List<Customer> findByLimitGreaterThanEqual(Double i);

}
