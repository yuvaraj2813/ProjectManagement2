package com.example.Project_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskMembersRequest {
    private Long taskId;
    private Long userId;
}
