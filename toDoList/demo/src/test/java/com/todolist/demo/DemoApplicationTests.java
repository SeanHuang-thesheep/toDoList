package com.todolist.demo;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todolist.demo.mappers.UserMapper;
import com.todolist.demo.pojo.Users;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void insertUser() {
		Users user = new Users("testuser", "testpassword", "testemail@example.com", LocalDateTime.now());
		userMapper.insertUser(user);
	}

	@Test
	void findByUsername() {
		Users user = userMapper.findByUsername("testuser");
		Assertions.assertEquals("testuser", user.getUsername());
	}

}
