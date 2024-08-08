package com.example.TaskManager.services;

import com.example.TaskManager.dto.TaskDto;
import com.example.TaskManager.enums.Priority;
import com.example.TaskManager.enums.taskStatus;
import com.example.TaskManager.repositoryes.TaskRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService
{
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public TaskDto getTaskById(Long id) {
       TaskDto task = taskRepository.getTaskById(id);
        return task;
    }

    public TaskDto createTask( String title, String description,
                           taskStatus status, Priority priority,
                           Long creatorId, Long assigneeId) {
       TaskDto task = taskRepository.createTask(title, description, status, priority, creatorId, assigneeId);
        return task;
    }

    public TaskDto updateTask(Long id, String title, String description,
                           taskStatus status, Priority priority,
                           Long creatorId, Long assigneeId) {
       TaskDto task =  taskRepository.updateTask(id, title,description,status,priority,creatorId,assigneeId);
       return task;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteTaskById(id);
    }
}
