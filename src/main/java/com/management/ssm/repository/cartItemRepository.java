package com.management.ssm.repository;

import com.management.ssm.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartItemRepository extends JpaRepository<CartItem, Long> {
}
