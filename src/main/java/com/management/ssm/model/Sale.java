package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLSALE")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SALE_ID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SALEPRODUCT_ID")
    private Product SALEPRODUCT_ID;

    @Column(name = "SALE_QUANTITY")
    private double SALE_QUANTITY;

    @Column(name = "SALEIS_ACTIVE")
    private String SALEIS_ACTIVE;

    @ManyToOne
    @JoinColumn(name = "SALEORDER_ID")
    private Order SALEORDER_ID;

    @JsonIgnore
    @Column(name = "SALEMODIFIED_BY")
    private String SALEMODIFIED_BY;

    @JsonIgnore
    @Column(name = "SALEMODIFIED_WHEN")
    private String SALEMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "SALEMODIFIED_WORKSTATION")
    private String SALEMODIFIED_WORKSTATION;

    public void setSALEPRODUCT_ID(Product SALEPRODUCT_ID) {
        this.SALEPRODUCT_ID = SALEPRODUCT_ID;
    }

    public void setSALE_QUANTITY(double SALE_QUANTITY) {
        this.SALE_QUANTITY = SALE_QUANTITY;
    }

    public void setSALEORDER_ID(Order SALEORDER_ID) {
        this.SALEORDER_ID = SALEORDER_ID;
    }

    public long getSALE_ID() {
        return SALE_ID;
    }

    public void setSALE_ID(long sALE_ID) {
        SALE_ID = sALE_ID;
    }

    public String getSALEIS_ACTIVE() {
        return SALEIS_ACTIVE;
    }

    public void setSALEIS_ACTIVE(String sALEIS_ACTIVE) {
        SALEIS_ACTIVE = sALEIS_ACTIVE;
    }

    public String getSALEMODIFIED_BY() {
        return SALEMODIFIED_BY;
    }

    public void setSALEMODIFIED_BY(String sALEMODIFIED_BY) {
        SALEMODIFIED_BY = sALEMODIFIED_BY;
    }

    public String getSALEMODIFIED_WHEN() {
        return SALEMODIFIED_WHEN;
    }

    public void setSALEMODIFIED_WHEN(String sALEMODIFIED_WHEN) {
        SALEMODIFIED_WHEN = sALEMODIFIED_WHEN;
    }

    public String getSALEMODIFIED_WORKSTATION() {
        return SALEMODIFIED_WORKSTATION;
    }

    public void setSALEMODIFIED_WORKSTATION(String sALEMODIFIED_WORKSTATION) {
        SALEMODIFIED_WORKSTATION = sALEMODIFIED_WORKSTATION;
    }

    public Product getSALEPRODUCT_ID() {
        return SALEPRODUCT_ID;
    }

    public double getSALE_QUANTITY() {
        return SALE_QUANTITY;
    }

}
