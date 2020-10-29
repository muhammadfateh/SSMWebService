package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLACCOUNTANTS")


public class Accountant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ACCOUNTANTSTAFF_ID;

    @Column(name = "ACCOUNTANT_USERNAME")
    private String ACCOUNTANT_USERNAME;

    @Column(name = "ACCOUNTANT_PASSWORD")
    private String ACCOUNTANT_PASSWORD;

    @Column(name = "ACCOUNTANT_NAME")
    private String ACCOUNTANT_NAME;

    @Column(name = "ACCOUNTANT_ADDRESS")
    private String ACCOUNTANT_ADDRESS;

    @Column(name = "ACCOUNTANTCONTACT_NO")
    private String ACCOUNTANTCONTACT_NO;

    @Column(name = "ACCOUNTANT_SALARY")
    private String ACCOUNTANT_SALARY;

    @JsonIgnore
    @Column(name = "ACCOUTANTMODIFIED_BY")
    private String ACCOUTANTMODIFIED_BY;

    @JsonIgnore
    @Column(name = "ACCOUNTANTMODIFIED_WHEN")
    private String ACCOUNTANTMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "ACCOUNTANTMODIFIED_WORKSTATION")
    private String ACCOUNTANTMODIFIED_WORKSTATION;

    @JsonIgnore
    @Column(name = "ACCOUNTANTIS_ACTIVE")
    private String ACCOUNTANTIS_ACTIVE;


    public long getACCOUNTANTSTAFF_ID() {
        return ACCOUNTANTSTAFF_ID;
    }

    public void setACCOUNTANTSTAFF_ID(long aCCOUNTANTSTAFF_ID) {
        ACCOUNTANTSTAFF_ID = aCCOUNTANTSTAFF_ID;
    }

    public String getACCOUNTANT_USERNAME() {
        return ACCOUNTANT_USERNAME;
    }

    public void setACCOUNTANT_USERNAME(String aCCOUNTANT_USERNAME) {
        ACCOUNTANT_USERNAME = aCCOUNTANT_USERNAME;
    }

    public String getACCOUNTANT_PASSWORD() {
        return ACCOUNTANT_PASSWORD;
    }

    public void setACCOUNTANT_PASSWORD(String aCCOUNTANT_PASSWORD) {
        ACCOUNTANT_PASSWORD = aCCOUNTANT_PASSWORD;
    }

    public String getACCOUNTANT_NAME() {
        return ACCOUNTANT_NAME;
    }

    public void setACCOUNTANT_NAME(String aCCOUNTANT_NAME) {
        ACCOUNTANT_NAME = aCCOUNTANT_NAME;
    }

    public String getACCOUNTANT_ADDRESS() {
        return ACCOUNTANT_ADDRESS;
    }

    public void setACCOUNTANT_ADDRESS(String aCCOUNTANT_ADDRESS) {
        ACCOUNTANT_ADDRESS = aCCOUNTANT_ADDRESS;
    }

    public String getACCOUNTANTCONTACT_NO() {
        return ACCOUNTANTCONTACT_NO;
    }

    public void setACCOUNTANTCONTACT_NO(String aCCOUNTANTCONTACT_NO) {
        ACCOUNTANTCONTACT_NO = aCCOUNTANTCONTACT_NO;
    }

    public String getACCOUNTANT_SALARY() {
        return ACCOUNTANT_SALARY;
    }

    public void setACCOUNTANT_SALARY(String aCCOUNTANT_SALARY) {
        ACCOUNTANT_SALARY = aCCOUNTANT_SALARY;

    }

    public String getACCOUTANTMODIFIED_BY() {
        return ACCOUTANTMODIFIED_BY;
    }

    public void setACCOUTANTMODIFIED_BY(String aCCOUTANTMODIFIED_BY) {
        ACCOUTANTMODIFIED_BY = aCCOUTANTMODIFIED_BY;
    }

    public String getACCOUNTANTMODIFIED_WHEN() {
        return ACCOUNTANTMODIFIED_WHEN;
    }

    public void setACCOUNTANTMODIFIED_WHEN(String aCCOUNTANTMODIFIED_WHEN) {
        ACCOUNTANTMODIFIED_WHEN = aCCOUNTANTMODIFIED_WHEN;
    }

    public String getACCOUNTANTMODIFIED_WORKSTATION() {
        return ACCOUNTANTMODIFIED_WORKSTATION;
    }

    public void setACCOUNTANTMODIFIED_WORKSTATION(String aCCOUNTANTMODIFIED_WORKSTATION) {
        ACCOUNTANTMODIFIED_WORKSTATION = aCCOUNTANTMODIFIED_WORKSTATION;
    }

    public String getACCOUNTANTIS_ACTIVE() {
        return ACCOUNTANTIS_ACTIVE;
    }

    public void setACCOUNTANTIS_ACTIVE(String aCCOUNTANTIS_ACTIVE) {
        ACCOUNTANTIS_ACTIVE = aCCOUNTANTIS_ACTIVE;
    }
}
