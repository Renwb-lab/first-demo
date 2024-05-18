package com.first.demo.controller;

import com.first.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.first.demo.service.UserService;

@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(path = "test")
    public String hello() {
        return "hello springboot";
    }

    @ResponseBody
    @GetMapping("/users")
    public String getUsers(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @ResponseBody
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return "hello " + id;
    }

    @PostMapping("/create/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // 使用user对象进行处理，例如保存到数据库
        User savedUser = userService.createUser(user);

        // 处理完毕后返回响应，例如返回成功消息
        return ResponseEntity.ok(savedUser);
    }
}
