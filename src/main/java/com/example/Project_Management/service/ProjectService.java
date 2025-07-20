package com.example.Project_Management.service;

import com.example.Project_Management.dto.CreateProjectRequest;
import com.example.Project_Management.entity.Project;
import com.example.Project_Management.entity.ProjectMembership;
import com.example.Project_Management.entity.User;
import com.example.Project_Management.repository.ProjectRepository;
import com.example.Project_Management.repository.UserRepository;
import com.example.Project_Management.repository.ProjectMembershipRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMembershipRepository projectMembershipRepository;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository,ProjectMembershipRepository projectMembershipRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.projectMembershipRepository=projectMembershipRepository;
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

        Project savedProject = projectRepository.save(project);
        //also create the projectMembership id for the Project manager

        ProjectMembership  membership=new ProjectMembership();
        membership.setUser_id(manager);
        membership.setProject_id(project);
        membership.setRole("PROJECT_MANAGER");
        projectMembershipRepository.save(membership);

        return savedProject;
    }

}
