package com.todolist.demo.services;

import com.todolist.demo.mappers.UserMapper;
import com.todolist.demo.pojo.LoginRequest;
import com.todolist.demo.pojo.LoginResponse;
import com.todolist.demo.pojo.RegisterRequest;
import com.todolist.demo.pojo.Result;
import com.todolist.demo.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Result register(RegisterRequest request) {
        if (request.getUsername() == null || request.getUsername().isBlank()) {
            return Result.error("Username is required");
        }

        if (request.getPassword() == null || request.getPassword().isBlank()) {
            return Result.error("Password is required");
        }

        User existingUser = userMapper.findByUsername(request.getUsername());

        if (existingUser != null) {
            return Result.error("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userMapper.insertUser(user);

        return Result.success();
    }

    public Result login(LoginRequest request) {
        User user = userMapper.findByUsername(request.getUsername());

        if (user == null) {
            return Result.error("User not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return Result.error("Incorrect password");
        }

        LoginResponse loginResponse = new LoginResponse(user.getId(), user.getUsername());

        return Result.success(loginResponse);
    }
}