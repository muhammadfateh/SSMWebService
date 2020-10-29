package com.management.ssm.repository;

import com.management.ssm.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface staffRepository extends JpaRepository<Staff, Long> {


    @Query(value = "select* from TBLSTAFF where STAFFIS_ACTIVE='Y'", nativeQuery = true)
    public List<Staff> findActive();

    @Query(value = "select* from TBLSTAFF "
            + "where STAFF_NAME like '%'+?1+'%'", nativeQuery = true)
    public List<Staff> findAllBySearch(String search);

    @Query(value = "select* from TBLSTAFF "
            + "where (STAFF_NAME like '%'+?1+'%'"
            + ")and STAFFIS_ACTIVE='Y'", nativeQuery = true)
    public List<Staff> findBySearch(String search);


    @Query(value = "select* from TBLSTAFF where STAFFIS_ACTIVE='Y'"
            + "and (case when ?1=null then STAFF_NAME=STAFF_NAME else STAFF_NAME like '%'+?1+'%')"
            , nativeQuery = true)
    public List<Staff> findByAdvancedSearch(String search);

    @Query(value = "select* from TBLSTAFF where "
            + "(case when ?1=null then STAFF_NAME=STAFF_NAME else STAFF_NAME like '%'+?1+'%')"
            , nativeQuery = true)
    public List<Staff> findAllByAdvancedSearch(String search);


}
