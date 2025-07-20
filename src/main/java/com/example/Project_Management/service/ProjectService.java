package com.example.Project_Management.service;

import com.example.Project_Management.dto.CreateProjectRequest;
import com.example.Project_Management.entity.Project;
import com.example.Project_Management.entity.User;
import com.example.Project_Management.repository.ProjectRepository;
import com.example.Project_Management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(CreateProjectRequest req) {
        User manager = userRepository.findById(req.getManagerId())
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        User creator = userRepository.findById(req.getCreatedById())
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        Project project = new Project();
        project.setTitle(req.getTitle());
        project.setDescription(req.getDescription());
        project.setDeadline(req.getDeadline());
        project.setStatus(req.getStatus());
        project.setProjectManager(manager);
        project.setCreatedBy(creator);

        return projectRepository.save(project);
    }

}
