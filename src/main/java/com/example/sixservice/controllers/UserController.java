package com.example.sixservice.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.sixservice.models.UserModel;
import com.example.sixservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @GetMapping( path = "/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping( path = "/query")
    public ArrayList<UserModel> getByUsername(@RequestParam("username") String username) {
        return this.userService.getByUsername(username);
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

}