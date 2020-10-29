package com.management.ssm.repository;

import com.management.ssm.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface supplierRepository extends JpaRepository<Supplier, Long> {

}
