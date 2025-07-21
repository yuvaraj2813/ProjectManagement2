package com.example.Project_Management.repository;

import com.example.Project_Management.entity.TaskMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskMembersRepository extends JpaRepository<TaskMembers,Long> {
}
