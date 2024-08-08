package com.example.TaskManager;

import com.example.TaskManager.controllers.TaskController;
import com.example.TaskManager.dto.TaskDto;
import com.example.TaskManager.entity.users;
import com.example.TaskManager.enums.Priority;
import com.example.TaskManager.enums.taskStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    TaskController taskController = new TaskController();


    @Test
    public void testCreateTask() throws NullPointerException
    {
        users user = new users();
        TaskDto taskDto = new TaskDto();
        taskDto.setPriority(Priority.HIGH);
        taskDto.setStatus(taskStatus.COMPLETED);
        taskDto.setTitle("Test Title");
        taskDto.setDescription("Test Description");
        taskDto.setAssignee(user);
        taskDto.setCreator(user);
        taskDto.setId(1L);
        Assertions.assertEquals(taskController.createTask(taskDto).getStatusCode(),200);
    }

    @Test
    public void testGetTaskById()
    {
        users user = new users();
        TaskDto taskDto = new TaskDto();
        taskDto.setPriority(Priority.HIGH);
        taskDto.setStatus(taskStatus.COMPLETED);
        taskDto.setTitle("Test Title");
        taskDto.setDescription("Test Description");
        taskDto.setAssignee(user);
        taskDto.setCreator(user);
        taskDto.setId(1L);
        taskController.createTask(taskDto);

        Assertions.assertEquals(taskController.getTask(1L).getStatusCode(),200);
    }

    @Test
    public void testDeleteById()
    {
        users user = new users();
        TaskDto taskDto = new TaskDto();
        taskDto.setPriority(Priority.HIGH);
        taskDto.setStatus(taskStatus.COMPLETED);
        taskDto.setTitle("Test Title");
        taskDto.setDescription("Test Description");
        taskDto.setAssignee(user);
        taskDto.setCreator(user);
        taskDto.setId(1L);
        taskController.createTask(taskDto);
        Assertions.assertEquals(taskController.deleteTask(1L).getStatusCode(),200);
    }

    @Test
    public void testUpdateTask()
    {
        users user = new users();
        TaskDto taskDto = new TaskDto();
        taskDto.setPriority(Priority.HIGH);
        taskDto.setStatus(taskStatus.COMPLETED);
        taskDto.setTitle("Test Title");
        taskDto.setDescription("Test Description");
        taskDto.setAssignee(user);
        taskDto.setCreator(user);
        taskDto.setId(1L);
        taskController.createTask(taskDto);
        ////////////////////////
        TaskDto newTask = new TaskDto();
        users userNew = new users();
        newTask.setPriority(Priority.HIGH);
        newTask.setStatus(taskStatus.COMPLETED);
        newTask.setTitle("Test Title");
        newTask.setDescription("Test Description");
        newTask.setAssignee(userNew);
        newTask.setCreator(userNew);
        newTask.setId(1L);
        Assertions.assertEquals(taskController.updateTask(1L,newTask).getStatusCode(),200);
    }

}
