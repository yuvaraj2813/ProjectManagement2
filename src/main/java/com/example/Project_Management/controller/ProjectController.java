package com.example.Project_Management.controller;


import com.example.Project_Management.dto.CreateProjectRequest;
import com.example.Project_Management.entity.Project;
import com.example.Project_Management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public Project createProject(@RequestBody CreateProjectRequest request){
        return projectService.createProject(request);
    }
}
