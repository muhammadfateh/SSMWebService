package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TBLCARTITEM")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CARTITEM_ID;

    @JoinColumn(name = "CARTITEMCART_ID")
    @ManyToOne(targetEntity = Cart.class)
    private Cart CARTITEMCART_ID;

    @OneToOne
    @JoinColumn(name = "CARTITEMPRODUCT_ID")
    private Product CARTITEMPRODUCT_ID;

    @Column
    private double CARTITEM_QUANTITY;

    public long getCARTITEM_ID() {
        return CARTITEM_ID;
    }

    public void setCARTITEM_ID(long CARTITEM_ID) {
        this.CARTITEM_ID = CARTITEM_ID;
    }

    @JsonIgnore
    public Cart getCARTITEMCART_ID() {
        return CARTITEMCART_ID;
    }

    public void setCARTITEMCART_ID(Cart CARTITEMCART_ID) {
        this.CARTITEMCART_ID = CARTITEMCART_ID;
    }

    public Product getCARTITEMPRODUCT_ID() {
        return CARTITEMPRODUCT_ID;
    }

    public void setCARTITEMPRODUCT_ID(Product CARTITEMPRODUCT_ID) {
        this.CARTITEMPRODUCT_ID = CARTITEMPRODUCT_ID;
    }

    public double getCARTITEM_QUANTITY() {
        return CARTITEM_QUANTITY;
    }

    public void setCARTITEM_QUANTITY(double CARTITEM_QUANTITY) {
        this.CARTITEM_QUANTITY = CARTITEM_QUANTITY;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CartItem))
            return false;
        CartItem item = (CartItem) o;
        return Objects.equals(getCARTITEMPRODUCT_ID(), item.getCARTITEMPRODUCT_ID())
                && Objects.equals(getCARTITEMCART_ID(), item.getCARTITEMCART_ID());
    }
}
