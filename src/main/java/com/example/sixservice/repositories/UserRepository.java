package com.example.sixservice.repositories;

import java.util.ArrayList;

import com.example.sixservice.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByUsername(String username);
}