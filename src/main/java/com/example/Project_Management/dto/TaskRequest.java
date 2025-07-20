package com.example.Project_Management.dto;

import com.example.Project_Management.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private  Long id;
    private Long projectid;
    private String title;
    private String description;
    private LocalDate deadline;

}
