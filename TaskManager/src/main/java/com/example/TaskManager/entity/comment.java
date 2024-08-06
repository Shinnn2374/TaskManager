package com.example.TaskManager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class comment
{
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private com.example.TaskManager.entity.task task;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private users author;
}
