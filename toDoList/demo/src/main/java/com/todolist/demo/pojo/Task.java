package com.todolist.demo.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime dueDatetime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}