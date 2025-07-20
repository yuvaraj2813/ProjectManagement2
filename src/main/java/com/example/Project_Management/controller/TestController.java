package com.example.Project_Management.controller;

import com.example.Project_Management.Util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    private final JwtUtil jwtUtil;

    public TestController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/protected")
    public String protectedEndpoint(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return "Missing or invalid Authorization header";
        }
        String token = authHeader.substring(7);
        if (!jwtUtil.validateToken(token)) {
            return "Invalid or expired token";
        }
        String email = jwtUtil.getEmailFromToken(token);
        String role = jwtUtil.getRoleFromToken(token);

        // Example: Only allow ADMIN
        if ("ADMIN".equals(role)) {
            return "Access denied: ADMIN role required";
        }

        return "Hello, " + email + "! You have ADMIN access.";
    }
}
