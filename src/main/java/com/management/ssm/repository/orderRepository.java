package com.management.ssm.repository;

import com.management.ssm.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order, Long> {

}
