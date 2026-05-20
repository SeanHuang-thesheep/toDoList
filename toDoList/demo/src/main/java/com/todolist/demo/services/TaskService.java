package com.todolist.demo.services;

import com.todolist.demo.mappers.TaskMapper;
import com.todolist.demo.pojo.Result;
import com.todolist.demo.pojo.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public Result findByUserId(Long userId) {
        List<Task> tasks = taskMapper.findByUserId(userId);
        return Result.success(tasks);
    }

    public Result findById(Long id) {
        Task task = taskMapper.findById(id);

        if (task == null) {
            return Result.error("Todo not found");
        }

        return Result.success(task);
    }

    public Result addTask(Task task) {
        if (task.getUserId() == null) {
            return Result.error("User ID is required");
        }

        if (task.getTitle() == null || task.getTitle().isBlank()) {
            return Result.error("Title is required");
        }

        taskMapper.insertTask(task);

        return Result.success();
    }

    public Result updateTask(Long id, Task task) {
        Task existingTask = taskMapper.findById(id);

        if (existingTask == null) {
            return Result.error("Todo not found");
        }

        task.setId(id);
        taskMapper.updateTask(task);

        return Result.success();
    }

    public Result deleteTask(Long id) {
        Task existingTask = taskMapper.findById(id);

        if (existingTask == null) {
            return Result.error("Todo not found");
        }

        taskMapper.deleteTask(id);

        return Result.success();
    }

    public Result updateStatus(Long id, Boolean completed) {
        Task existingTask = taskMapper.findById(id);

        if (existingTask == null) {
            return Result.error("Todo not found");
        }

        taskMapper.updateStatus(id, completed);

        return Result.success();
    }
}
