package com.example.SpringBootL.controller;


import com.example.SpringBootL.entity.UserEntity;
import com.example.SpringBootL.models.User;
import com.example.SpringBootL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
}
