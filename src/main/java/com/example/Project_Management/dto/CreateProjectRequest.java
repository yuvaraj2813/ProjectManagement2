package com.example.Project_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRequest {
    private String title;
    private String description;
    private LocalDate deadline;
    private String status;
    private Long managerId;
    private Long createdById;
}
