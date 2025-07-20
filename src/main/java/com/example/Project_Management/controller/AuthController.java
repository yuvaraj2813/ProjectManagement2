package com.example.Project_Management.controller;

import com.example.Project_Management.Util.JwtUtil;
import com.example.Project_Management.dto.LoginRequest;
import com.example.Project_Management.dto.RegisterRequest;
import com.example.Project_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public  String registerUser(@RequestBody RegisterRequest request){
        userService.registerUser(request);
        return "User Register Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginUser(request);
    }
}
