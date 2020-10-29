package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLADMINISTRATOR")

public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ADMIN_ID;

    @Column(name = "ADMIN_NAME")
    private String ADMIN_NAME;

    @Column(name = "ADMINUSER_NAME")
    private String ADMINUSER_NAME;

    @Column(name = "ADMIN_PASSWORD")
    private String ADMIN_PASSWORD;

    @JsonIgnore
    @Column(name = "ADMINIS_ACTIVE")
    private char ADMINIS_ACTIVE;

    @JsonIgnore
    @Column(name = "ADMINMODIFIED_BY")
    private String ADMINMODIFIED_BY;

    @JsonIgnore
    @Column(name = "ADMINMODIFIED_WHEN")
    private String ADMINMODIFIED_WHEN;

    @JsonIgnore
    @Column(name = "ADMINMODIFIED_WORKSTATION")
    private String ADMINMODIFIED_WORKSTATION;

    public long getADMIN_ID() {
        return ADMIN_ID;
    }

    public void setADMIN_ID(long aDMIN_ID) {
        ADMIN_ID = aDMIN_ID;
    }

    public String getADMIN_NAME() {
        return ADMIN_NAME;
    }

    public void setADMIN_NAME(String aDMIN_NAME) {
        ADMIN_NAME = aDMIN_NAME;
    }

    public String getADMINUSER_NAME() {
        return ADMINUSER_NAME;
    }

    public void setADMINUSER_NAME(String aDMINUSER_NAME) {
        ADMINUSER_NAME = aDMINUSER_NAME;
    }

    public String getADMIN_PASSWORD() {
        return ADMIN_PASSWORD;
    }

    public void setADMIN_PASSWORD(String aDMIN_PASSWORD) {
        ADMIN_PASSWORD = aDMIN_PASSWORD;
    }

    public char getADMINIS_ACTIVE() {
        return ADMINIS_ACTIVE;
    }

    public void setADMINIS_ACTIVE(char aDMINIS_ACTIVE) {
        ADMINIS_ACTIVE = aDMINIS_ACTIVE;
    }

    public String getADMINMODIFIED_BY() {
        return ADMINMODIFIED_BY;
    }

    public void setADMINMODIFIED_BY(String aDMINMODIFIED_BY) {
        ADMINMODIFIED_BY = aDMINMODIFIED_BY;
    }

    public String getADMINMODIFIED_WHEN() {
        return ADMINMODIFIED_WHEN;
    }

    public void setADMINMODIFIED_WHEN(String aDMINMODIFIED_WHEN) {
        ADMINMODIFIED_WHEN = aDMINMODIFIED_WHEN;
    }

    public String getADMINMODIFIED_WORKSTATION() {
        return ADMINMODIFIED_WORKSTATION;
    }

    public void setADMINMODIFIED_WORKSTATION(String aDMINMODIFIED_WORKSTATION) {
        ADMINMODIFIED_WORKSTATION = aDMINMODIFIED_WORKSTATION;
    }

}
