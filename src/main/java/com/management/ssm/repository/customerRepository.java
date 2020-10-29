package com.management.ssm.repository;

import com.management.ssm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customer, Long> {

}