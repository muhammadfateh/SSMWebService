package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLCUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CUSTOMER_ID;

    @Column(name = "CUSTOMER_NAME")
    private String CUSTOMER_NAME;

    @Column(name = "CUSTOMERCONTACT_NO")
    private String CUSTOMERCONTACT_NO;

    @Column(name = "CUSTOMER_PASSWORD")
    private String CUSTOMER_PASSWORD;

    @Column(name = "CUSTOMERIS_ACTIVE")
    private String CUSTOMERIS_ACTIVE;

    @OneToMany(mappedBy = "CARTCUSTOMER_ID", cascade = CascadeType.ALL, targetEntity = Cart.class)
    private Set<Cart> shoppingcarts = new HashSet<Cart>();

    @OneToMany(mappedBy = "CPCUSTOMER_ID", cascade = CascadeType.ALL, targetEntity = CustomerProduct.class, orphanRemoval = true)
    private Set<CustomerProduct> customerreviews = new HashSet<CustomerProduct>();

    @OneToMany(mappedBy = "LOGCUSTOMER_ID", cascade = CascadeType.ALL, targetEntity = Log.class)
    private Set<Log> customerlogs = new HashSet<Log>();

    @JsonIgnore
    @Column(name = "CUSTOMERMODIFIED_BY")
    private String CUSTOMERMODIFIED_BY;

    @JsonIgnore
    @Column(name = "CUSTOMERMODIFIED_WHEN")
    private String CUSTOMERMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "CUSTOMERMODIFIED_WORKSTATION")
    private String CUSTOMERMODIFIED_WORKSTATION;

    public long getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(long cUSTOMER_ID) {
        CUSTOMER_ID = cUSTOMER_ID;
    }

    public String getCUSTOMER_NAME() {
        return CUSTOMER_NAME;
    }

    public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
        CUSTOMER_NAME = cUSTOMER_NAME;
    }

    public String getCUSTOMERCONTACT_NO() {
        return CUSTOMERCONTACT_NO;
    }

    public void setCUSTOMERCONTACT_NO(String cUSTOMERCONTACT_NO) {
        CUSTOMERCONTACT_NO = cUSTOMERCONTACT_NO;
    }

    public String getCUSTOMER_PASSWORD() {
        return CUSTOMER_PASSWORD;
    }

    public void setCUSTOMER_PASSWORD(String CUSTOMER_PASSWORD) {
        this.CUSTOMER_PASSWORD = CUSTOMER_PASSWORD;
    }

    public String getCUSTOMERIS_ACTIVE() {
        return CUSTOMERIS_ACTIVE;
    }

    public void setCUSTOMERIS_ACTIVE(String cUSTOMERIS_ACTIVE) {
        CUSTOMERIS_ACTIVE = cUSTOMERIS_ACTIVE;
    }

    public String getCUSTOMERMODIFIED_BY() {
        return CUSTOMERMODIFIED_BY;
    }

    public void setCUSTOMERMODIFIED_BY(String cUSTOMERMODIFIED_BY) {
        CUSTOMERMODIFIED_BY = cUSTOMERMODIFIED_BY;
    }

    public String getCUSTOMERMODIFIED_WHEN() {
        return CUSTOMERMODIFIED_WHEN;
    }

    public void setCUSTOMERMODIFIED_WHEN(String cUSTOMERMODIFIED_WHEN) {
        CUSTOMERMODIFIED_WHEN = cUSTOMERMODIFIED_WHEN;
    }

    public String getCUSTOMERMODIFIED_WORKSTATION() {
        return CUSTOMERMODIFIED_WORKSTATION;
    }

    public void setCUSTOMERMODIFIED_WORKSTATION(String cUSTOMERMODIFIED_WORKSTATION) {
        CUSTOMERMODIFIED_WORKSTATION = cUSTOMERMODIFIED_WORKSTATION;
    }

    public Set<Cart> getShoppingcarts() {
        return shoppingcarts;
    }

    public void setShoppingcarts(Set<Cart> shoppingcarts) {
        this.shoppingcarts = shoppingcarts;
    }

    public Set<CustomerProduct> getCustomerreviews() {
        return customerreviews;
    }

    public void setCustomerreviews(Set<CustomerProduct> customerreviews) {
        this.customerreviews = customerreviews;
    }

    public Set<Log> getCustomerlogs() {
        return customerlogs;
    }

    public void setCustomerlogs(Set<Log> customerlogs) {
        this.customerlogs = customerlogs;
    }

    public void removeReview(CustomerProduct review) {
        this.getCustomerreviews().remove(review);
    }

}
