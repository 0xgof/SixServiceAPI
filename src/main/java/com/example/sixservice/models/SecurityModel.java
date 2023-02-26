package com.example.sixservice.models;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
@Table(name = "securities")
public class SecurityModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    public String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSecurityName(String name) {
    this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getname() {
        return name;
    }
}