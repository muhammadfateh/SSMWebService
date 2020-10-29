package com.management.ssm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.ssm.model.ProductType;

public interface productTypeRepository extends JpaRepository<ProductType, Long> {

}
