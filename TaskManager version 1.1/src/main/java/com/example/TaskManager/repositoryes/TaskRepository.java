package com.example.TaskManager.repositoryes;

import com.example.TaskManager.dto.TaskDto;
import com.example.TaskManager.entity.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<task, Long>
{
    TaskDto getTaskById(Long id);
    TaskDto createTask(TaskDto taskDto);
    TaskDto updateTask(Long id, TaskDto taskDto);
    void deleteTask(Long id);
}
