package com.management.ssm.repository;

import com.management.ssm.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
