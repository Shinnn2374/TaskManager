package com.example.TaskManager.repositoryes;

import com.example.TaskManager.dto.TaskDto;
import com.example.TaskManager.entity.task;
import com.example.TaskManager.enums.Priority;
import com.example.TaskManager.enums.taskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface TaskRepository extends JpaRepository<task, Long>
{

    @Query("SELECT t FROM task t WHERE t.id = :id")
    TaskDto getTaskById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO task (title, description, status, priority, creator_id, assignee_id) " +
            "VALUES (:title, :description, :status, :priority, :creatorId, :assigneeId)", nativeQuery = true)
    TaskDto createTask(@Param("title") String title,
                    @Param("description") String description,
                    @Param("status") taskStatus status,
                    @Param("priority") Priority priority,
                    @Param("creatorId") Long creatorId,
                    @Param("assigneeId") Long assigneeId);


    @Transactional
    @Modifying
    @Query(value = "UPDATE task SET title = :title, description = :description, status = :status, " +
            "priority = :priority, creator_id = :creatorId, assignee_id = :assigneeId " +
            "WHERE id = :id", nativeQuery = true)
    TaskDto updateTask(@Param("id") Long id,
                    @Param("title") String title,
                    @Param("description") String description,
                    @Param("status") taskStatus status,
                    @Param("priority") Priority priority,
                    @Param("creatorId") Long creatorId,
                    @Param("assigneeId") Long assigneeId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM task WHERE id = :id", nativeQuery = true)
    void deleteTaskById(@Param("id") Long id);
}
