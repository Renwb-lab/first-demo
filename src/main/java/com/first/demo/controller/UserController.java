package com.first.demo.controller;

import com.first.demo.model.FriendsResponse;
import com.first.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.first.demo.service.UserService;

import java.util.List;

/**
 * @author wenbin.ren
 */
@RestController
public class UserController {
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

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.selectById(id);
    }

    @PostMapping("/create/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // 使用user对象进行处理，例如保存到数据库
        User savedUser = userService.createUser(user);

        // 处理完毕后返回响应，例如返回成功消息
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/query/users")
    public ResponseEntity<List<User>> searchUsers(@RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "id", required = false) Long id ) {
        List<User> users = userService.searchUsers(new User(id, name, ""));
        return ResponseEntity.ok(users);
    }

    @GetMapping("/query/friends")
    public ResponseEntity<FriendsResponse> selectFriendById(@RequestParam(value = "id", required = true) Long id) {
        List<User> users = userService.selectFriendsById(id);
        int count = userService.selectFriendCountById(id);
        return ResponseEntity.ok(new FriendsResponse(users, count));
    }
}
