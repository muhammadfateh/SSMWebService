package com.management.ssm.repository;

import com.management.ssm.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface purchaseRepository extends JpaRepository<Purchase, Long> {

}
