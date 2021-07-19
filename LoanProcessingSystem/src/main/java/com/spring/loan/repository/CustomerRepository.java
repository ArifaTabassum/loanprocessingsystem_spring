package com.spring.loan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.loan.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	

}