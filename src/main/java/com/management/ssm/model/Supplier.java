package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLSUPPLIER")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long SUPPLIER_ID;

    @Column(name = "SUPPLIER_NAME")
    private String SUPPLIER_NAME;

    @Column(name = "SUPPLIERCONTACT_NO")
    private String SUPPLIERCONTACT_NO;

    @Column(name = "SUPPLIER_EMAIL")
    private String SUPPLIER_EMAIL;

    @Column(name = "SUPPLIERIS_ACTIVE")
    private char SUPPLIERIS_ACTIVE;

    @JsonIgnore
    @Column(name = "SUPPLIERMODIFIED_BY")
    private String SUPPLIERMODIFIED_BY;

    @JsonIgnore
    @Column(name = "SUPPLIERMODIFIED_WHEN")
    private String SUPPLIERMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "SUPPLIERMODIFIED_WORKSTATION")
    private String SUPPLIERMODIFIED_WORKSTATION;

    public long getSUPPLIER_ID() {
        return SUPPLIER_ID;
    }

    public void setSUPPLIER_ID(long sUPPLIER_ID) {
        SUPPLIER_ID = sUPPLIER_ID;
    }

    public String getSUPPLIER_NAME() {
        return SUPPLIER_NAME;
    }

    public void setSUPPLIER_NAME(String sUPPLIER_NAME) {
        SUPPLIER_NAME = sUPPLIER_NAME;
    }

    public String getSUPPLIERCONTACT_NO() {
        return SUPPLIERCONTACT_NO;
    }

    public void setSUPPLIERCONTACT_NO(String sUPPLIERCONTACT_NO) {
        SUPPLIERCONTACT_NO = sUPPLIERCONTACT_NO;
    }

    public String getSUPPLIER_EMAIL() {
        return SUPPLIER_EMAIL;
    }

    public void setSUPPLIER_EMAIL(String sUPPLIER_EMAIL) {
        SUPPLIER_EMAIL = sUPPLIER_EMAIL;
    }

    public char getSUPPLIERIS_ACTIVE() {
        return SUPPLIERIS_ACTIVE;
    }

    public void setSUPPLIERIS_ACTIVE(char sUPPLIERIS_ACTIVE) {
        SUPPLIERIS_ACTIVE = sUPPLIERIS_ACTIVE;
    }

    public String getSUPPLIERMODIFIED_BY() {
        return SUPPLIERMODIFIED_BY;
    }

    public void setSUPPLIERMODIFIED_BY(String sUPPLIERMODIFIED_BY) {
        SUPPLIERMODIFIED_BY = sUPPLIERMODIFIED_BY;
    }

    public String getSUPPLIERMODIFIED_WHEN() {
        return SUPPLIERMODIFIED_WHEN;
    }

    public void setSUPPLIERMODIFIED_WHEN(String sUPPLIERMODIFIED_WHEN) {
        SUPPLIERMODIFIED_WHEN = sUPPLIERMODIFIED_WHEN;
    }

    public String getSUPPLIERMODIFIED_WORKSTATION() {
        return SUPPLIERMODIFIED_WORKSTATION;
    }

    public void setSUPPLIERMODIFIED_WORKSTATION(String sUPPLIERMODIFIED_WORKSTATION) {
        SUPPLIERMODIFIED_WORKSTATION = sUPPLIERMODIFIED_WORKSTATION;
    }


}
