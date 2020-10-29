package com.management.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.datalogs.model.DatabaseTables;

public interface databaseTablesRepository extends JpaRepository<DatabaseTables, Long> {

}
