package com.todolist.demo.controllers;

import com.todolist.demo.pojo.LoginRequest;
import com.todolist.demo.pojo.RegisterRequest;
import com.todolist.demo.pojo.Result;
import com.todolist.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
