package com.example.Project_Management.repository;

import com.example.Project_Management.entity.Project;
import com.example.Project_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
