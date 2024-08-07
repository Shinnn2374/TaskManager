package com.example.TaskManager.services;

import com.example.TaskManager.dto.TaskDto;
import com.example.TaskManager.repositoryes.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService
{
    private TaskRepository taskRepository;


    public TaskDto getTaskById(Long id) {
        // Реализуйте логику получения задачи
        return null;
    }

    public TaskDto createTask(TaskDto taskDto) {
        // Реализуйте логику создания задачи
        return null;
    }

    public TaskDto updateTask(Long id, TaskDto taskDto) {
        // Реализуйте логику обновления задачи
        return null;
    }

    public void deleteTask(Long id) {
        // Реализуйте логику удаления задачи
    }
}
