package com.JobApp.JobAppManagement.controller;


import com.JobApp.JobAppManagement.Model.User;

import com.JobApp.JobAppManagement.Service.JwtService;
import com.JobApp.JobAppManagement.Service.Registerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private Registerservice registerservice;
    @Autowired
    private AuthenticationManager authenticationManager;

//    @GetMapping("register")
//    public List<User> getalluser()
//    {
//        return registerservice.getalluser();
//    }

    @PostMapping("register")
    public User register(@RequestBody User user)
    {
        return  registerservice.register(user);
    }

    @PostMapping("login")
    public String login (@RequestBody User user)
    {
        Authentication authentication =authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
        {
            return jwtService.generateToken(user.getUsername());
        }
        else {
            return "Failed";
        }
    }



}
