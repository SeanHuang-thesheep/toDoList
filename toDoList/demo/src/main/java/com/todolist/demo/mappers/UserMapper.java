package com.todolist.demo.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.todolist.demo.pojo.Users;

@Mapper
public interface UserMapper {
    Users findByUsername(String username);
    void insertUser(Users user);
}