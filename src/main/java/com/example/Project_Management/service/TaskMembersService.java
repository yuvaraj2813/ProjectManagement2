package com.example.Project_Management.service;

import com.example.Project_Management.entity.*;
import com.example.Project_Management.repository.*;
import org.springframework.stereotype.Service;

@Service
public class TaskMembersService {

    private final TaskMembersRepository taskMembersRepository;
    private final TaskRepository taskRepository;
    private final ProjectMembershipRepository projectMembershipRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public TaskMembersService(
            TaskMembersRepository taskMembersRepository,
            TaskRepository taskRepository,
            ProjectMembershipRepository projectMembershipRepository,UserRepository userRepository,ProjectRepository projectRepository) {
        this.taskMembersRepository=taskMembersRepository;
        this.taskRepository = taskRepository;
        this.projectMembershipRepository = projectMembershipRepository;
        this.userRepository=userRepository;
        this.projectRepository=projectRepository;
    }

    public TaskMembers addTaskMembers(Long taskId, Long userId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        Long projectId = task.getProject().getId();

        TaskMembers taskMember = new TaskMembers();
        taskMember.setUserId(userId);
        taskMember.setTask(task);
        taskMembersRepository.save(taskMember);


        User user= userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Project project= (Project) projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        ProjectMembership membership = new ProjectMembership();
        membership.setProject_id(project);
        membership.setUser_id(user);
        membership.setRole("MEMBER");
        projectMembershipRepository.save(membership);

        return taskMember;
    }
}
