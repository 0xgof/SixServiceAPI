package com.example.sixservice.models;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
@Table(name = "trades")
public class TradeModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    private Long sellOrderId;
    private Long buyOrderId; 
    private double price; 
    private double quantity; 

    public void setId(Long id) {
        this.id = id;
    }

    public void setSellOrderId(Long sellOrderId) {
    this.sellOrderId = sellOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
    this.buyOrderId = buyOrderId;
    }

    public void setPrice(double price) {
    this.price = price;
    }

    public void setQuantity(double quantity) {
    this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public Long getBuyOrderId() {
        return buyOrderId;
    }

        public double getPrice() {
        return price;
    }

        public double getQuantity() {
        return quantity;
    }

}