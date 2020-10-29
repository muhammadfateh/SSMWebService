package com.management.ssm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TBLPRODUCTTYPE")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long PRODUCTTYPE_ID;

    @Column(name = "PRODUCTTYPE_NAME")
    private String PRODUCTTYPE_NAME;

    @Column(name = "PRODUCTTYPEIS_ACTIVE")
    private char PRODUCTTYPEIS_ACTIVE;

    @JsonIgnore
    @Column(name = "PRODUCTTYPEMODIFIED_BY")
    private String PRODUCTTYPEMODIFIED_BY;

    @JsonIgnore
    @Column(name = "PRODUCTTYPEMODIFIED_WHEN")
    private String PRODUCTTYPEMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "PRODUCTTYPEMODIFIED_WORKSTATION")
    private String PRODUCTTYPEMODIFIED_WORKSTATION;

    public long getPRODUCTTYPE_ID() {
        return PRODUCTTYPE_ID;
    }

    public void setPRODUCTTYPE_ID(long pRODUCTTYPE_ID) {
        PRODUCTTYPE_ID = pRODUCTTYPE_ID;
    }

    public String getPRODUCTTYPE_NAME() {
        return PRODUCTTYPE_NAME;
    }

    public void setPRODUCTTYPE_NAME(String pRODUCTTYPE_NAME) {
        PRODUCTTYPE_NAME = pRODUCTTYPE_NAME;
    }

    public char getPRODUCTTYPEIS_ACTIVE() {
        return PRODUCTTYPEIS_ACTIVE;
    }

    public void setPRODUCTTYPEIS_ACTIVE(char pRODUCTTYPEIS_ACTIVE) {
        PRODUCTTYPEIS_ACTIVE = pRODUCTTYPEIS_ACTIVE;
    }

    public String getPRODUCTTYPEMODIFIED_BY() {
        return PRODUCTTYPEMODIFIED_BY;
    }

    public void setPRODUCTTYPEMODIFIED_BY(String pRODUCTTYPEMODIFIED_BY) {
        PRODUCTTYPEMODIFIED_BY = pRODUCTTYPEMODIFIED_BY;
    }

    public String getPRODUCTTYPEMODIFIED_WHEN() {
        return PRODUCTTYPEMODIFIED_WHEN;
    }

    public void setPRODUCTTYPEMODIFIED_WHEN(String pRODUCTTYPEMODIFIED_WHEN) {
        PRODUCTTYPEMODIFIED_WHEN = pRODUCTTYPEMODIFIED_WHEN;
    }

    public String getPRODUCTTYPEMODIFIED_WORKSTATION() {
        return PRODUCTTYPEMODIFIED_WORKSTATION;
    }

    public void setPRODUCTTYPEMODIFIED_WORKSTATION(String pRODUCTTYPEMODIFIED_WORKSTATION) {
        PRODUCTTYPEMODIFIED_WORKSTATION = pRODUCTTYPEMODIFIED_WORKSTATION;
    }


}
