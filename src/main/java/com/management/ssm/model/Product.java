package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLPRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private long PRODUCT_ID;

    @Column(name = "PRODUCT_NAME")
    private String PRODUCT_NAME;

    @Column(name = "PRODUCT_STOCK")
    private double PRODUCT_STOCK;

    @Column(name = "PRODUCT_PRICE")
    private double PRODUCT_PRICE;

    @Column(name = "PRODUCTIMAGE_PATH")
    private String PRODUCTIMAGE_PATH;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String PRODUCT_DESCRIPTION;

    @Column(name = "PRODUCTIS_ACTIVE")
    private char PRODUCTIS_ACTIVE;

    @JsonIgnore
    @Column(name = "PRODUCTMODIFIED_BY")
    private String PRODUCTMODIFIED_BY;

    @JsonIgnore
    @Column(name = "PRODUCTMODIFIED_WHEN")
    private String PRODUCTMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "PRODUCTMODIFIED_WORKSTATION")
    private String PRODUCTMODIFIED_WORKSTATION;

    //    For reviews given by multiple customers to multiple products.
    @OneToMany(mappedBy = "CPPRODUCT_ID", cascade = CascadeType.ALL, targetEntity = CustomerProduct.class, orphanRemoval = true)
    private Set<CustomerProduct> productreviews = new HashSet<CustomerProduct>();

    //    Having ProductCategory
    @JoinColumn(name = "PRODUCTCATEGORY_ID")
    @ManyToOne(cascade = {CascadeType.DETACH}, targetEntity = ProductCategory.class)
    private ProductCategory PRODUCTCATEGORY_ID;


    public long getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(long pRODUCT_ID) {
        PRODUCT_ID = pRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String pRODUCT_NAME) {
        PRODUCT_NAME = pRODUCT_NAME;
    }

    public double getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(double pRODUCT_STOCK) {
        PRODUCT_STOCK = pRODUCT_STOCK;
    }

    public double getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(double PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public ProductCategory getPRODUCTCATEGORY_ID() {
        return PRODUCTCATEGORY_ID;
    }

    public void setPRODUCTCATEGORY_ID(ProductCategory PRODUCTCATEGORY_ID) {
        this.PRODUCTCATEGORY_ID = PRODUCTCATEGORY_ID;
    }

    public String getPRODUCTMODIFIED_BY() {
        return PRODUCTMODIFIED_BY;
    }

    public void setPRODUCTMODIFIED_BY(String pRODUCTMODIFIED_BY) {
        PRODUCTMODIFIED_BY = pRODUCTMODIFIED_BY;
    }

    public String getPRODUCTMODIFIED_WHEN() {
        return PRODUCTMODIFIED_WHEN;
    }

    public void setPRODUCTMODIFIED_WHEN(String pRODUCTMODIFIED_WHEN) {
        PRODUCTMODIFIED_WHEN = pRODUCTMODIFIED_WHEN;
    }

    public String getPRODUCTMODIFIED_WORKSTATION() {
        return PRODUCTMODIFIED_WORKSTATION;
    }

    public void setPRODUCTMODIFIED_WORKSTATION(String pRODUCTMODIFIED_WORKSTATION) {
        PRODUCTMODIFIED_WORKSTATION = pRODUCTMODIFIED_WORKSTATION;
    }

    public char getPRODUCTIS_ACTIVE() {
        return PRODUCTIS_ACTIVE;
    }

    public void setPRODUCTIS_ACTIVE(char pRODUCTIS_ACTIVE) {
        PRODUCTIS_ACTIVE = pRODUCTIS_ACTIVE;
    }

    public Set<CustomerProduct> getProductreviews() {
        return productreviews;
    }

    public void setProductreviews(Set<CustomerProduct> productreviews) {
        this.productreviews = productreviews;
    }

    public void removeReview(CustomerProduct review) {
        this.getProductreviews().remove(review);
    }

    public String getPRODUCTIMAGE_PATH() {
        return PRODUCTIMAGE_PATH;
    }

    public void setPRODUCTIMAGE_PATH(String PRODUCTIMAGE_PATH) {
        this.PRODUCTIMAGE_PATH = PRODUCTIMAGE_PATH;
    }
}
