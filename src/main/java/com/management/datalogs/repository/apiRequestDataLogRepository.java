package com.management.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.datalogs.model.APIRequestDataLog;

public interface apiRequestDataLogRepository extends JpaRepository<APIRequestDataLog, Long> {

}
