package com.management.ssm.repository;

import com.management.ssm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface productRepository extends JpaRepository<Product, Long> {
    @Query(value = "select* from TBLPRODUCT where PRODUCTIS_ACTIVE='Y'", nativeQuery = true)
    public List<Product> findActive();

    @Query(value = "select* from TBLPRODUCT " + "where PRODUCT_NAME like '%'+?1+'%'", nativeQuery = true)
    public List<Product> findAllBySearch(String search);

    @Query(value = "select* from TBLPRODUCT " + "where (PRODUCT_NAME like '%'+?1+'%'"
            + ")and PRODUCTIS_ACTIVE='Y'", nativeQuery = true)
    public List<Product> findBySearch(String search);

    @Query(value = "select* from TBLPRODUCT where PRODUCTIS_ACTIVE='Y'"
            + "and (case when ?1=null then PRODUCT_NAME=PRODUCT_NAME else PRODUCT_NAME like '%'+?1+'%')", nativeQuery = true)
    public List<Product> findByAdvancedSearch(String search);

    @Query(value = "select* from TBLPRODUCT where "
            + "(case when ?1=null then PRODUCT_NAME=PRODUCT_NAME else PRODUCT_NAME like '%'+?1+'%')", nativeQuery = true)
    public List<Product> findAllByAdvancedSearch(String search);
}