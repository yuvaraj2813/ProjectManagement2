package com.example.Project_Management.service;

import com.example.Project_Management.dto.LoginRequest;
import com.example.Project_Management.dto.RegisterRequest;
import com.example.Project_Management.entity.User;
import com.example.Project_Management.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already Exists");
        }
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode((req.getPassword())));
        user.setGlobalRole("USER");
        userRepository.save(user);
    }

    public String loginUser(LoginRequest req) {
        return userRepository.findByEmail(req.getEmail())
                .filter(user -> passwordEncoder.matches(req.getPassword(), user.getPassword()))
                .map(user -> "Login successful")
                .orElse("Invalid email or password");
    }
}
