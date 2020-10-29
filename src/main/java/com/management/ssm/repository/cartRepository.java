package com.management.ssm.repository;

import com.management.ssm.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepository extends JpaRepository<Cart, Long> {
}
