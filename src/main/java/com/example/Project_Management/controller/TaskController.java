package com.example.Project_Management.controller;


import com.example.Project_Management.dto.TaskRequest;
import com.example.Project_Management.entity.Task;
import com.example.Project_Management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskRequest req) {
        return taskService.createTask(req);
    }
}
