package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLPRODUCTCATERGORY")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long PRODUCTCATERGORY_ID;

    @Column(name = "PRODUCTCATERGORY_NAME")
    private String PRODUCTCATERGORY_NAME;

    @Column(name = "PRODUCTCATERGORY_ACTIVE")
    private char PRODUCTCATERGORY_ACTIVE;

    @OneToMany(mappedBy = "PRODUCTCATEGORY_ID", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<Product>();

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "PRODUCTCATEGORYPARENT_ID")
    private ProductCategory PRODUCTCATEGORYPARENT_ID;

    @JsonIgnore
    @Column(name = "PRODUCTCATERGORYMODIFIED_BY")
    private String PRODUCTCATERGORYMODIFIED_BY;

    @JsonIgnore
    @Column(name = "PRODUCTCATERGORYMODIFIED_WHEN")
    private String PRODUCTCATERGORYMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "PRODUCTCATERGORYMODIFIED_WORKSTATION")
    private String PRODUCTCATERGORYMODIFIED_WORKSTATION;

    public long getPRODUCTCATERGORY_ID() {
        return PRODUCTCATERGORY_ID;
    }

    public void setPRODUCTCATERGORY_ID(long PRODUCTCATERGORY_ID) {
        this.PRODUCTCATERGORY_ID = PRODUCTCATERGORY_ID;
    }

    public String getPRODUCTCATERGORY_NAME() {
        return PRODUCTCATERGORY_NAME;
    }

    public void setPRODUCTCATERGORY_NAME(String PRODUCTCATERGORY_NAME) {
        this.PRODUCTCATERGORY_NAME = PRODUCTCATERGORY_NAME;
    }

    public char getPRODUCTCATERGORY_ACTIVE() {
        return PRODUCTCATERGORY_ACTIVE;
    }

    public void setPRODUCTCATERGORY_ACTIVE(char PRODUCTCATERGORY_ACTIVE) {
        this.PRODUCTCATERGORY_ACTIVE = PRODUCTCATERGORY_ACTIVE;
    }

    public String getPRODUCTCATERGORYMODIFIED_BY() {
        return PRODUCTCATERGORYMODIFIED_BY;
    }

    public void setPRODUCTCATERGORYMODIFIED_BY(String PRODUCTCATERGORYMODIFIED_BY) {
        this.PRODUCTCATERGORYMODIFIED_BY = PRODUCTCATERGORYMODIFIED_BY;
    }

    public String getPRODUCTCATERGORYMODIFIED_WHEN() {
        return PRODUCTCATERGORYMODIFIED_WHEN;
    }

    public void setPRODUCTCATERGORYMODIFIED_WHEN(String PRODUCTCATERGORYMODIFIED_WHEN) {
        this.PRODUCTCATERGORYMODIFIED_WHEN = PRODUCTCATERGORYMODIFIED_WHEN;
    }

    public String getPRODUCTCATERGORYMODIFIED_WORKSTATION() {
        return PRODUCTCATERGORYMODIFIED_WORKSTATION;
    }

    public void setPRODUCTCATERGORYMODIFIED_WORKSTATION(String PRODUCTCATERGORYMODIFIED_WORKSTATION) {
        this.PRODUCTCATERGORYMODIFIED_WORKSTATION = PRODUCTCATERGORYMODIFIED_WORKSTATION;
    }

    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public ProductCategory getPRODUCTCATEGORYPARENT_ID() {
        return PRODUCTCATEGORYPARENT_ID;
    }

    public void setPRODUCTCATEGORYPARENT_ID(ProductCategory PRODUCTCATEGORYPARENT_ID) {
        this.PRODUCTCATEGORYPARENT_ID = PRODUCTCATEGORYPARENT_ID;
    }
}
