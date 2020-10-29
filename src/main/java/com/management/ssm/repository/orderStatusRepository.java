package com.management.ssm.repository;

import com.management.ssm.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderStatusRepository extends JpaRepository<OrderStatus, Long> {

}
