package com.management.ssm.repository;

import com.management.ssm.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface accountantRepository extends JpaRepository<Accountant, Long> {

    @Query(value = "select* from TBLACCOUNTANT where ACCOUNTAANTIS_ACTIVE='Y'", nativeQuery = true)
    public List<Accountant> findActive();

    @Query(value = "select* from TBLACCOUNTANT "
            + "where ACCOUNTANT_NAME like '%'+?1+'%'", nativeQuery = true)
    public List<Accountant> findAllBySearch(String search);

    @Query(value = "select* from TBLACCOUNTANT "
            + "where (ACCOUNTANT_NAME like '%'+?1+'%'"
            + ")and ACCOUNTANTIS_ACTIVE='Y'", nativeQuery = true)
    public List<Accountant> findBySearch(String search);


    //@Query(value="select* from TBLACCOUNTANT where ACCOUNTANTIS_ACTIVE='Y'"
    //	+ "and (case when ?1=null then ACCOUNTANT_NAME=ACCOUNTANT_NAME else ACCOUNTANT_NAME like '%'+?1+'%')"
    //	,nativeQuery=true)
    //public List<Accountant> findByAdvancedSearch(String search);

    //@Query(value="select* from TBLACCOUNTANT where "
    //	+ "(case when ?1=null then ACCOUNTANT_NAME=ACCOUNTANT_NAME else ACCOUNTANT_NAME like '%'+?1+'%')"
    //	,nativeQuery=true)
    //	public List<Accountant> findAllByAdvancedSearch(String search);


}



