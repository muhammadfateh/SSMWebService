package com.management.ssm.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLORDERSTATUS")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ORDERSTATUS_ID;

    @Column(name = "ORDERSTATUS_NAME")
    private String ORDERSTATUS_NAME;

    public long getORDERSTATUS_ID() {
        return ORDERSTATUS_ID;
    }

    public void setORDERSTATUS_ID(long oRDERSTATUS_ID) {
        ORDERSTATUS_ID = oRDERSTATUS_ID;
    }

    public String getORDERSTATUS_NAME() {
        return ORDERSTATUS_NAME;
    }

    public void setORDERSTATUS_NAME(String oRDERSTATUS_NAME) {
        ORDERSTATUS_NAME = oRDERSTATUS_NAME;
    }

}
