package com.todolist.demo.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private int user_id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime due_datetime;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
