package com.example.sixservice.models;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
@Table(name = "users")
public class UserModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id; 

    private String username;
    private String password; 

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
    this.username = username;
    }

    public void setPassword(String password) {
    this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}