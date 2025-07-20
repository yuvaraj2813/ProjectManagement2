package com.example.Project_Management.service;

import com.example.Project_Management.dto.TaskRequest;
import com.example.Project_Management.entity.Project;
import com.example.Project_Management.entity.Task;
import com.example.Project_Management.repository.ProjectRepository;
import com.example.Project_Management.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public Task createTask(TaskRequest req) {
        Project project = projectRepository.findById(req.getProjectid())
                .orElseThrow(() -> new RuntimeException("Project not found"));


        Task task = new Task();
        task.setProject(project);
        task.setTitle(req.getTitle());
        task.setDescription(req.getDescription());
        task.setDeadline(req.getDeadline());

        return taskRepository.save(task);
    }
}
