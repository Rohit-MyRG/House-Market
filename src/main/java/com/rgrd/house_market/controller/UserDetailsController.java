package com.rgrd.house_market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgrd.house_market.model.UserDetails;
import com.rgrd.house_market.repositories.UserDetailsRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/authenticate/users")
public class UserDetailsController {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UserDetails> getAllUsers() {
        return userDetailsRepository.findAll();
    }
    
    @PostMapping
    public UserDetails addUser(@Valid @RequestBody UserDetails userDtails) {
        String encodedPassword = passwordEncoder.encode(userDtails.getPassword());
        userDtails.setPassword(encodedPassword);

        return userDetailsRepository.save(userDtails);
    }
    
}
