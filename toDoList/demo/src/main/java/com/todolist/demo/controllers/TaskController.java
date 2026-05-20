package com.todolist.demo.controllers;

import com.todolist.demo.pojo.Result;
import com.todolist.demo.pojo.Task;
import com.todolist.demo.pojo.TaskStatusRequest;
import com.todolist.demo.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Result findByUserId(@RequestParam Long userId) {
        return taskService.findByUserId(userId);
    }

    @PostMapping
    public Result addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public Result updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public Result deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    @PatchMapping("/{id}/status")
    public Result updateStatus(@PathVariable Long id, @RequestBody TaskStatusRequest request) {
        return taskService.updateStatus(id, request.getCompleted());
    }
}