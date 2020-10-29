package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ORDER_ID;

    @Column(name = "ORDER_DATE")
    private String ORDER_DATE;

    @Column(name = "ORDER_STATUS")
    private int ORDER_STATUS;

    @Column(name = "ORDERIS_ACTIVE")
    private int ORDERIS_ACTIVE;

    @JsonIgnore
    @Column(name = "ORDERMODIFIED_BY")
    private String ORDERMODIFIED_BY;

    @JsonIgnore
    @Column(name = "ORDERMODIFIED_WHEN")
    private String ORDERMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "ORDERMODIFIED_WORKSTATION")
    private String ORDERMODIFIED_WORKSTATION;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERACCOUNT_ID", unique = true)
    private Account ORDERACCOUNT_ID;

    @OneToMany(mappedBy = "SALEORDER_ID", cascade = CascadeType.ALL)
    private Set<Sale> sales = new HashSet<Sale>();

    public long getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(long ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public String getORDER_DATE() {
        return ORDER_DATE;
    }

    public void setORDER_DATE(String ORDER_DATE) {
        this.ORDER_DATE = ORDER_DATE;
    }

    public Account getORDERACCOUNT_ID() {
        return ORDERACCOUNT_ID;
    }

    public void setORDERACCOUNT_ID(Account ORDERACCOUNT_ID) {
        this.ORDERACCOUNT_ID = ORDERACCOUNT_ID;
    }

    public String getORDERMODIFIED_BY() {
        return ORDERMODIFIED_BY;
    }

    public void setORDERMODIFIED_BY(String ORDERMODIFIED_BY) {
        this.ORDERMODIFIED_BY = ORDERMODIFIED_BY;
    }

    public String getORDERMODIFIED_WHEN() {
        return ORDERMODIFIED_WHEN;
    }

    public void setORDERMODIFIED_WHEN(String ORDERMODIFIED_WHEN) {
        this.ORDERMODIFIED_WHEN = ORDERMODIFIED_WHEN;
    }

    public String getORDERMODIFIED_WORKSTATION() {
        return ORDERMODIFIED_WORKSTATION;
    }

    public void setORDERMODIFIED_WORKSTATION(String ORDERMODIFIED_WORKSTATION) {
        this.ORDERMODIFIED_WORKSTATION = ORDERMODIFIED_WORKSTATION;
    }

    public int getORDER_STATUS() {
        return ORDER_STATUS;
    }

    public void setORDER_STATUS(int ORDER_STATUS) {
        this.ORDER_STATUS = ORDER_STATUS;
    }

    public int getORDERIS_ACTIVE() {
        return ORDERIS_ACTIVE;
    }

    public void setORDERIS_ACTIVE(int ORDERIS_ACTIVE) {
        this.ORDERIS_ACTIVE = ORDERIS_ACTIVE;
    }
}
