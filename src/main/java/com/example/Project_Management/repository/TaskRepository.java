package com.example.Project_Management.repository;

import com.example.Project_Management.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
