package com.vishwa.SpringSecurity.controller;

import com.vishwa.SpringSecurity.model.User;
import com.vishwa.SpringSecurity.service.JwtService;
import com.vishwa.SpringSecurity.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService service;
    @Autowired
    private JwtService jwtService;
    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
                return jwtService.generateToken(user.getUsername());
        else
            return "Login Failed";
    }
}
