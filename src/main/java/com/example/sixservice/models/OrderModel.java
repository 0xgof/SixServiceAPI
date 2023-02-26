package com.example.sixservice.models;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
@Table(name = "market_orders")
public class OrderModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    public Long userId;
    public Long securityId; 
    private String type; 
    public double price; 
    public double quantity; 
    private Boolean fullfilled;  

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userid) {
    this.userId = userid;
    }

    public void setSecurityId(Long securityId) {
    this.securityId = securityId;
    }

    public void setType(String type) {
    this.type = type;
    }

    public void setPrice(double price) {
    this.price = price;
    }

    public void setQuantity(double quantity) {
    this.quantity = quantity;
    }

    public void setFullfilled(Boolean fullfilled) {
    this.fullfilled = fullfilled;
    }

    public Long getId() {
        return id;
    }

    public Long getUserid() {
        return userId;
    }

        public Long getSecurityId() {
        return securityId;
    }

        public String getType() {
        return type;
    }

        public double getPrice() {
        return price;
    }

        public double getQuantity() {
        return quantity;
    }

        public Boolean getFullfilled() {
        return fullfilled;
    }
}