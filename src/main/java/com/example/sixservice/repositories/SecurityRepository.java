package com.example.sixservice.repositories;

import java.util.ArrayList;

import com.example.sixservice.models.SecurityModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends CrudRepository<SecurityModel, Long> {
    public abstract ArrayList<SecurityModel> findByName(String name);
}