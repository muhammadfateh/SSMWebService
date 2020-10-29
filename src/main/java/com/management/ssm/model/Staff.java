package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLSTAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long STAFF_ID;

    @Column(name = "STAFF_NAME")
    private String STAFF_NAME;

    @Column(name = "STAFF_ADDRESS")
    private String STAFF_ADDRESS;

    @Column(name = "STAFFCONTACT_NO")
    private String STAFFCONTACT_NO;

    @Column(name = "STAFF_SALARY")
    private String STAFF_SALARY;

    @Column(name = "STAFFIS_ACTIVE")
    private String STAFFIS_ACTIVE;

    @JsonIgnore
    @Column(name = "STAFFMODIFIED_BY")
    private String STAFFMODIFIED_BY;

    @JsonIgnore
    @Column(name = "STAFFMODIFIED_WHEN")
    private String STAFFMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "STAFFMODIFIED_WORKSTATION")
    private String STAFFMODIFIED_WORKSTATION;

    public long getSTAFF_ID() {
        return STAFF_ID;
    }

    public void setSTAFF_ID(long sTAFF_ID) {
        STAFF_ID = sTAFF_ID;
    }

    public String getSTAFF_NAME() {
        return STAFF_NAME;
    }

    public void setSTAFF_NAME(String sTAFF_NAME) {
        STAFF_NAME = sTAFF_NAME;
    }

    public String getSTAFF_ADDRESS() {
        return STAFF_ADDRESS;
    }

    public void setSTAFF_ADDRESS(String sTAFF_ADDRESS) {
        STAFF_ADDRESS = sTAFF_ADDRESS;
    }

    public String getSTAFFCONTACT_NO() {
        return STAFFCONTACT_NO;
    }

    public void setSTAFFCONTACT_NO(String sTAFFCONTACT_NO) {
        STAFFCONTACT_NO = sTAFFCONTACT_NO;
    }

    public String getSTAFF_SALARY() {
        return STAFF_SALARY;
    }

    public void setSTAFF_SALARY(String sTAFF_SALARY) {
        STAFF_SALARY = sTAFF_SALARY;
    }

    public String getSTAFFIS_ACTIVE() {
        return STAFFIS_ACTIVE;
    }

    public void setSTAFFIS_ACTIVE(String sTAFFIS_ACTIVE) {
        STAFFIS_ACTIVE = sTAFFIS_ACTIVE;
    }

    public String getSTAFFMODIFIED_BY() {
        return STAFFMODIFIED_BY;
    }

    public void setSTAFFMODIFIED_BY(String sTAFFMODIFIED_BY) {
        STAFFMODIFIED_BY = sTAFFMODIFIED_BY;
    }

    public String getSTAFFMODIFIED_WHEN() {
        return STAFFMODIFIED_WHEN;
    }

    public void setSTAFFMODIFIED_WHEN(String sTAFFMODIFIED_WHEN) {
        STAFFMODIFIED_WHEN = sTAFFMODIFIED_WHEN;
    }

    public String getSTAFFMODIFIED_WORKSTATION() {
        return STAFFMODIFIED_WORKSTATION;
    }

    public void setSTAFFMODIFIED_WORKSTATION(String sTAFFMODIFIED_WORKSTATION) {
        STAFFMODIFIED_WORKSTATION = sTAFFMODIFIED_WORKSTATION;
    }


}
