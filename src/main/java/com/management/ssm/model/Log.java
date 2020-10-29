package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLLOG")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long LOG_ID;

    @Column(name = "LOG_dATE")
    private String LOG_dATE;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "LOGCUSTOMER_ID")
    private Customer LOGCUSTOMER_ID;

    public long getLOG_ID() {
        return LOG_ID;
    }

    public void setLOG_ID(long LOG_ID) {
        this.LOG_ID = LOG_ID;
    }

    public String getLOG_dATE() {
        return LOG_dATE;
    }

    public void setLOG_dATE(String LOG_dATE) {
        this.LOG_dATE = LOG_dATE;
    }

    @JsonIgnore
    public Customer getLOGCUSTOMER_ID() {
        return LOGCUSTOMER_ID;
    }

    public void setLOGCUSTOMER_ID(Customer LOGCUSTOMER_ID) {
        this.LOGCUSTOMER_ID = LOGCUSTOMER_ID;
    }
}
