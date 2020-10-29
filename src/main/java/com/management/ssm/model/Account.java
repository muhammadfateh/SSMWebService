package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "TBLACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ACCOUNT_ID;

    @Column(name = "ACCOUNT_TOTAL")
    private double ACCOUNT_TOTAL;

    @Column(name = "ACCOUNT_DISCOUNT")
    private double ACCOUNT_DISCOUNT;

    @JsonIgnore
    @OneToOne(mappedBy = "ORDERACCOUNT_ID")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public void setACCOUNT_ID(long aCCOUNT_ID) {
        ACCOUNT_ID = aCCOUNT_ID;
    }

    public double getACCOUNT_TOTAL() {
        return ACCOUNT_TOTAL;
    }

    public void setACCOUNT_TOTAL(double aCCOUNT_TOTAL) {
        ACCOUNT_TOTAL = aCCOUNT_TOTAL;
    }

    public double getACCOUNT_DISCOUNT() {
        return ACCOUNT_DISCOUNT;
    }

    public void setACCOUNT_DISCOUNT(double aCCOUNT_DISCOUNT) {
        ACCOUNT_DISCOUNT = aCCOUNT_DISCOUNT;
    }

}
