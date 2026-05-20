package com.todolist.demo.mappers;

import com.todolist.demo.pojo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {

    List<Task> findByUserId(@Param("userId") Long userId);

    Task findById(@Param("id") Long id);

    int insertTask(Task task);

    int updateTask(Task task);

    int deleteTask(@Param("id") Long id);

    int updateStatus(@Param("id") Long id, @Param("completed") Boolean completed);
}