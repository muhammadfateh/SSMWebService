package com.management.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.datalogs.model.TableDataLog;

public interface tableDataLogRepository extends JpaRepository<TableDataLog, Long> {

}
