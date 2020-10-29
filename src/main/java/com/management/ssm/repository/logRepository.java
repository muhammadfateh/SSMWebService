package com.management.ssm.repository;

import com.management.ssm.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface logRepository extends JpaRepository<Log, Long> {
}
