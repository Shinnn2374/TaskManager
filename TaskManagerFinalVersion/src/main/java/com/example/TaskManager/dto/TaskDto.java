package com.example.TaskManager.dto;

import com.example.TaskManager.entity.users;
import com.example.TaskManager.enums.Priority;
import com.example.TaskManager.enums.taskStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TaskDto
{
    private Long id;
    private String title;
    private String description;
    private taskStatus status;
    private Priority priority;
    private users creator;
    private users assignee;
}
