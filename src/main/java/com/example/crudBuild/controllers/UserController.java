package com.example.crudBuild.controllers;

import com.example.crudBuild.models.User;
import com.example.crudBuild.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List <User> getAllUsers () {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User createUser (@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser (@PathVariable Long id,@RequestBody User user) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setAddress(user.getAddress());
        existingUser.setAge(user.getAge());
        existingUser.setCondition(user.getCondition());
        existingUser.setGender(user.getGender());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            System.out.println("Deleting user with ID: " + id);
            userRepository.deleteById(id);
            return "User deleted";
        } else {
            return "User not found";
        }
    }
    }


