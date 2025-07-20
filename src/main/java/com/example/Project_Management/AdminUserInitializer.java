package com.example.Project_Management;

import com.example.Project_Management.entity.User;
import com.example.Project_Management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

    @Component
    public class AdminUserInitializer implements CommandLineRunner {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        public AdminUserInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args) {
            String adminEmail = "admin@example.com";
            if (!userRepository.existsByEmail(adminEmail)) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode("adminpassword")); // Hash the password
                admin.setGlobalRole("ADMIN");
                userRepository.save(admin);
                System.out.println("Admin user created!");
            }
        }
    }

