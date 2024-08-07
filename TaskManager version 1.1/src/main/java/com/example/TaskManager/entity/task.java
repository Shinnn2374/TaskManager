package com.example.TaskManager.entity;

import com.example.TaskManager.enums.Priority;
import com.example.TaskManager.enums.taskStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class task
{
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private taskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private users creator;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private users assignee;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<comment> comments;
}
