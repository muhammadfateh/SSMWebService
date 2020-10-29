package com.management.ssm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLCART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long CART_ID;

    @Column
    private int CART_STATUS;

    @Column
    private double CARTSUB_TOTAL;

    @OneToMany(mappedBy = "CARTITEMCART_ID", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartItem> cartItems = new HashSet<CartItem>();

    @JoinColumn(name = "CARTCUSTOMER_ID")
    @ManyToOne(targetEntity = Customer.class)
    private Customer CARTCUSTOMER_ID;

    public long getCART_ID() {
        return CART_ID;
    }

    public void setCART_ID(long CART_ID) {
        this.CART_ID = CART_ID;
    }

    public int getCART_STATUS() {
        return CART_STATUS;
    }

    public void setCART_STATUS(int CART_STATUS) {
        this.CART_STATUS = CART_STATUS;
    }

    public double getCARTSUB_TOTAL() {
        return CARTSUB_TOTAL;
    }

    public void setCARTSUB_TOTAL(double CARTSUB_TOTAL) {
        this.CARTSUB_TOTAL = CARTSUB_TOTAL;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @JsonIgnore
    public Customer getCARTCUSTOMER_ID() {
        return CARTCUSTOMER_ID;
    }

    public void setCARTCUSTOMER_ID(Customer CARTCUSTOMER_ID) {
        this.CARTCUSTOMER_ID = CARTCUSTOMER_ID;
    }
}
