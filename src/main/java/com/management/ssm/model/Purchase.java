package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLPURCHASE")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long PURCHASE_ID;

    @Column(name = "PURCHASE_DATE")
    private String PURCHASE_DATE;

    @Column(name = "PURCHASE_QUANTITY")
    private long PURCHASE_QUANTITY;

    @Column(name = "PURCHASEIS_ACTIVE")
    private char PURCHASEIS_ACTIVE;

    @JsonIgnore
    @Column(name = "PURCHASEMODIFIED_BY")
    private String PURCHASEMODIFIED_BY;

    @JsonIgnore
    @Column(name = "PURCHASEMODIFIED_WHEN")
    private String PURCHASEMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "PURCHASEMODIFIED_WORKSTATION")
    private String PURCHASEMODIFIED_WORKSTATION;

    @JoinColumn(name = "SUPPLIER_ID")
    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Supplier.class)
    private Supplier PURCHASESUPPLIER_ID;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(cascade = {CascadeType.ALL}, targetEntity = Product.class)
    private Product PURCHASEPRODUCT_ID;

    public long getPURCHASE_ID() {
        return PURCHASE_ID;
    }

    public void setPURCHASE_ID(long pURCHASE_ID) {
        PURCHASE_ID = pURCHASE_ID;
    }

    public String getPURCHASE_DATE() {
        return PURCHASE_DATE;
    }

    public void setPURCHASE_DATE(String pURCHASE_DATE) {
        PURCHASE_DATE = pURCHASE_DATE;
    }

    public long getPURCHASE_QUANTITY() {
        return PURCHASE_QUANTITY;
    }

    public void setPURCHASE_QUANTITY(long pURCHASE_QUANTITY) {
        PURCHASE_QUANTITY = pURCHASE_QUANTITY;
    }

    public char getPURCHASEIS_ACTIVE() {
        return PURCHASEIS_ACTIVE;
    }

    public void setPURCHASEIS_ACTIVE(char pURCHASEIS_ACTIVE) {
        PURCHASEIS_ACTIVE = pURCHASEIS_ACTIVE;
    }

    public String getPURCHASEMODIFIED_BY() {
        return PURCHASEMODIFIED_BY;
    }

    public void setPURCHASEMODIFIED_BY(String pURCHASEMODIFIED_BY) {
        PURCHASEMODIFIED_BY = pURCHASEMODIFIED_BY;
    }

    public String getPURCHASEMODIFIED_WHEN() {
        return PURCHASEMODIFIED_WHEN;
    }

    public void setPURCHASEMODIFIED_WHEN(String pURCHASEMODIFIED_WHEN) {
        PURCHASEMODIFIED_WHEN = pURCHASEMODIFIED_WHEN;
    }

    public String getPURCHASEMODIFIED_WORKSTATION() {
        return PURCHASEMODIFIED_WORKSTATION;
    }

    public void setPURCHASEMODIFIED_WORKSTATION(String pURCHASEMODIFIED_WORKSTATION) {
        PURCHASEMODIFIED_WORKSTATION = pURCHASEMODIFIED_WORKSTATION;
    }

    public Supplier getPURCHASESUPPLIER_ID() {
        return PURCHASESUPPLIER_ID;
    }

    public void setPURCHASESUPPLIER_ID(Supplier pURCHASESUPPLIER_ID) {
        PURCHASESUPPLIER_ID = pURCHASESUPPLIER_ID;
    }

    public Product getPURCHASEPRODUCT_ID() {
        return PURCHASEPRODUCT_ID;
    }

    public void setPURCHASEPRODUCT_ID(Product pURCHASEPRODUCT_ID) {
        PURCHASEPRODUCT_ID = pURCHASEPRODUCT_ID;
    }


}
