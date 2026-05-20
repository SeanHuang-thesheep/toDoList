package com.todolist.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String username;
    private String password;
    private String email;
    private LocalDateTime created_at;
}
