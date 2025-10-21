package com.example.SpringBootL.controller;


import com.example.SpringBootL.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public List<User> getUsers()
    {
        return Arrays.asList(new User(3L,"Alice","alice@gmail.com"),new User(1L,"John","john@gmail.com"),new User(2L,"Joe","joe@gmail.com"));

    }
}
