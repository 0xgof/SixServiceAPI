package com.example.sixservice.services;

import java.util.ArrayList;

import com.example.sixservice.repositories.SecurityRepository;
import com.example.sixservice.models.SecurityModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    SecurityRepository securityRepository;

    public ArrayList<SecurityModel> getSecurities(){
        return (ArrayList<SecurityModel>) securityRepository.findAll();
    }

    public SecurityModel saveSecurity(SecurityModel security){
        return securityRepository.save(security);

    }

    public ArrayList<SecurityModel> getByName(String name){
        return securityRepository.findByName(name);
    }
}