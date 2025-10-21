package com.example.SpringBootL.controller;


import com.example.SpringBootL.entity.UserEntity;
import com.example.SpringBootL.exceptions.ResouceNotFoundException;
import com.example.SpringBootL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<UserEntity> getUsers()
    {
        return userRepository.findAll();
    }
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user)
    {
        return userRepository.save(user);
    }


    @GetMapping("/{id}")
    //optional returns the userentity if that's available or else it returns null
    public UserEntity getUserById(@PathVariable Long id )
    {
        return userRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("User not found with this id"));
    }
}

