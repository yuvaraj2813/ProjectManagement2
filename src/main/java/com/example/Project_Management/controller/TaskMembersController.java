package com.example.Project_Management.controller;

import com.example.Project_Management.entity.TaskMembers;
import com.example.Project_Management.service.TaskMembersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taskMembers")
public class TaskMembersController {
    private final TaskMembersService taskMembersService;

    public TaskMembersController(TaskMembersService taskAssigneeService) {
        this.taskMembersService = taskAssigneeService;
    }

    @PostMapping("/add")
    public TaskMembers addTaskMembers(@RequestParam Long taskId, @RequestParam Long userId) {
        return taskMembersService.addTaskMembers(taskId, userId);
    }
}
