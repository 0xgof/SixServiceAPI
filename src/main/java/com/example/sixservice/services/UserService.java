package com.example.sixservice.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.sixservice.repositories.UserRepository;
import com.example.sixservice.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

}