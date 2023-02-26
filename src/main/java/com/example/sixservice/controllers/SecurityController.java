package com.example.sixservice.controllers;

import java.util.ArrayList;

import com.example.sixservice.models.SecurityModel;
import com.example.sixservice.services.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    SecurityService securityService;

    @GetMapping()
    public ArrayList<SecurityModel> getSecurities(){
        return securityService.getSecurities();
    }

    @GetMapping( path = "/query")
    public ArrayList<SecurityModel> getByName(@RequestParam("name") String name) {
        return this.securityService.getByName(name);
    }

    @PostMapping()
    public SecurityModel saveSecurity(@RequestBody SecurityModel security){
        return this.securityService.saveSecurity(security);
    }

}