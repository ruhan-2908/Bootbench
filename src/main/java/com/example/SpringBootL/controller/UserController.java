package com.example.SpringBootL.controller;


import com.example.SpringBootL.entity.UserEntity;
import com.example.SpringBootL.exceptions.ResouceNotFoundException;
import com.example.SpringBootL.models.User;
import com.example.SpringBootL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping //get all
    public List<UserEntity> getUsers()
    {
        return userRepository.findAll();
    }
    @GetMapping("/{id}") //get by id
    //optional returns the userentity if that's available or else it returns null
    public UserEntity getUserById(@PathVariable Long id )
    {
        return userRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("User not found with this id"));
    }
    @PostMapping // createuser
    public UserEntity createUser(@RequestBody UserEntity user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @PutMapping("/{id}") //update existing data of the user
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id)
    {
          UserEntity userData =  userRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("User not found with this id"));
          userData.setEmail(user.getEmail());
          userData.setName(user.getName());
          return userRepository.save(userData);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id)
    {
        UserEntity userdata = userRepository.findById(id).orElseThrow(() -> new ResouceNotFoundException("User not found with this id"));
        userRepository.delete(userdata);
        return ResponseEntity.ok().build();
    }
}

