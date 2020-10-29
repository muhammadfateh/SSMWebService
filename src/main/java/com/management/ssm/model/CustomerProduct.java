package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TBLCUSTOMERPRODUCT")
public class CustomerProduct implements Serializable {
    @Id
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "CPCUSTOMER_ID")
    private Customer CPCUSTOMER_ID;

    @Id
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "CPPRODUCT_ID")
    @JsonIgnore
    private Product CPPRODUCT_ID;

    @Column
    private String CP_REVIEW;

    @Column
    private String CP_Date;

    public void setCPCUSTOMER_ID(Customer CPCUSTOMER_ID) {
        this.CPCUSTOMER_ID = CPCUSTOMER_ID;
    }

    public void setCPPRODUCT_ID(Product CPPRODUCT_ID) {
        this.CPPRODUCT_ID = CPPRODUCT_ID;
    }

    public String getCP_REVIEW() {
        return CP_REVIEW;
    }

    public void setCP_REVIEW(String CP_REVIEW) {
        this.CP_REVIEW = CP_REVIEW;
    }

    public String getCP_Date() {
        return CP_Date;
    }

    public void setCP_Date(String CP_Date) {
        this.CP_Date = CP_Date;
    }

    @JsonIgnore
    public Customer getCPCUSTOMER_ID() {
        return CPCUSTOMER_ID;
    }

    @JsonIgnore
    public Product getCPPRODUCT_ID() {
        return CPPRODUCT_ID;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CustomerProduct))
            return false;
        CustomerProduct review = (CustomerProduct) o;
        return Objects.equals(getCPCUSTOMER_ID().getCUSTOMER_ID(), review.getCPCUSTOMER_ID().getCUSTOMER_ID()) &&
                Objects.equals(getCPPRODUCT_ID().getPRODUCT_ID(), review.getCPPRODUCT_ID().getPRODUCT_ID());
    }
}
