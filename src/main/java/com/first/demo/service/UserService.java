package com.first.demo.service;

import com.first.demo.mapper.UserMapper;
import com.first.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User createUser(User user) {
        boolean result = userMapper.save(user);
        if (result) {
            return user;
        } else {
            return null;
        }
    }
}
